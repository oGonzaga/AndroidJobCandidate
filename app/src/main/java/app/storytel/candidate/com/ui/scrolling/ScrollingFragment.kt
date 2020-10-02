package app.storytel.candidate.com.ui.scrolling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import app.storytel.candidate.com.R
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.ui.main.MainViewModel
import app.storytel.candidate.com.ui.main.PostAdapter
import kotlinx.android.synthetic.main.content_scrolling.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ScrollingFragment : Fragment() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter = PostAdapter(this::onPostClick)
    private val observer = Observer<List<Post>> {
        adapter.addItems(it)
        recycler_view.adapter = adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_scrolling, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.postList.observe(this.viewLifecycleOwner, observer)
    }

    private fun onPostClick(post: Post) {
        findNavController().navigate(R.id.postDetailFragment)
    }
}