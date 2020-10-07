package app.storytel.candidate.com.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import app.storytel.candidate.com.R
import app.storytel.candidate.com.data.model.Comment
import app.storytel.candidate.com.data_remote.ResourceList
import app.storytel.candidate.com.data_remote.model.Status
import app.storytel.candidate.com.ui.extensions.gone
import app.storytel.candidate.com.ui.extensions.invisible
import app.storytel.candidate.com.ui.extensions.visible
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_post_detail.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class PostDetailFragment : Fragment() {

    private val args: PostDetailFragmentArgs by navArgs()
    private val viewModel: PostDetailViewModel by viewModel()
    private val requestObserver = Observer<ResourceList<Comment>> {
        when (it.status) {
            Status.SUCCESS -> {
                pbLoading.gone()
                rvComment.visible()
                val adapter =  CommentAdapter(it.data!!)
                rvComment.adapter = adapter
            }
            Status.ERROR -> {
                pbLoading.gone()
                Toast.makeText(context, getString(R.string.error_text), Toast.LENGTH_LONG).show()
            }
            Status.LOADING -> {
                rvComment.invisible()
                pbLoading.visible()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.postId = args.post.id!!.toInt()
        return inflater.inflate(R.layout.fragment_post_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
        initObservers()
    }

    private fun initObservers() {
        viewModel.request.observe(this.viewLifecycleOwner, requestObserver)
    }

    private fun setupView() {
        args.post.let {
            details.text = it.title
                Glide.with(this)
                    .load(it.imageUrl)
                    .placeholder(R.drawable.ic_baseline_android)
                    .into(backdrop)
        }
    }
}