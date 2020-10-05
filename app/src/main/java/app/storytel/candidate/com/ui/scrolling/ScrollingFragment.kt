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
import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.Resource
import app.storytel.candidate.com.data_remote.model.Status
import app.storytel.candidate.com.ui.extensions.gone
import app.storytel.candidate.com.ui.extensions.visible
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.fragment_scrolling.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScrollingFragment : Fragment() {

    private val viewModel: ScrollingViewModel by viewModel()
    private val adapter = PostAdapter(this::onPostClick)
    private val postObserver = Observer<Resource<List<Post>>> {
        when (it.status) {
            Status.SUCCESS -> {
                pbLoading.gone()
                recyclerView.visible()
                adapter.addItems(it.data!!)
                recyclerView.adapter = adapter
            }
            Status.ERROR -> {
                pbLoading.gone()
                Toast.makeText(this.context, it.message, Toast.LENGTH_LONG).show()
            }
            Status.LOADING -> pbLoading.visible()
        }
    }
    private val photosObserver = Observer<Resource<List<Photo>>> {
        when (it.status) {
            Status.SUCCESS -> {
                pbLoading.gone()
                recyclerView.visible()

                recyclerView.adapter = adapter
            }
            Status.ERROR -> {
                pbLoading.gone()
                Toast.makeText(this.context, it.message, Toast.LENGTH_LONG).show()
            }
            Status.LOADING -> pbLoading.visible()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_scrolling, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.addItemDecoration(DividerItemDecoration(this.context, LinearLayout.HORIZONTAL))
        initObservers()
    }

    private fun initObservers() {
        viewModel.let {
            it.postList.observe(this.viewLifecycleOwner, postObserver)
            it.photosList.observe(this.viewLifecycleOwner, photosObserver)

        }
    }

    private fun onPostClick(post: Post) {
        findNavController().navigate(R.id.postDetailFragment)
    }
}