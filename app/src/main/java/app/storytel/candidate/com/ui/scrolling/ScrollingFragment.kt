package app.storytel.candidate.com.ui.scrolling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import app.storytel.candidate.com.R
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data.model.PostAndImages
import app.storytel.candidate.com.data_remote.Resource
import app.storytel.candidate.com.data_remote.model.Status
import app.storytel.candidate.com.ui.extensions.gone
import app.storytel.candidate.com.ui.extensions.invisible
import app.storytel.candidate.com.ui.extensions.visible
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.fragment_scrolling.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScrollingFragment : Fragment() {

    private val viewModel: ScrollingViewModel by viewModel()
    private val adapter = PostAdapter(this::onPostClick)
    private val requestObserver = Observer<Resource<PostAndImages>> {
        when (it.status) {
            Status.SUCCESS -> {
                pbLoading.gone()
                recyclerView.visible()
                adapter.addItems(it.data!!)
                recyclerView.adapter = adapter
            }
            Status.ERROR -> {
                pbLoading.gone()
                Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
            }
            Status.LOADING -> {
                pbLoading.visible()
                recyclerView.invisible()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_scrolling, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))

        initObservers()
    }

    private fun initObservers() {
        viewModel.getPostAndPhotos.observe(this.viewLifecycleOwner, requestObserver)
    }

    private fun onPostClick(post: Post) {
        findNavController().navigate(R.id.postDetailFragment)
    }
}