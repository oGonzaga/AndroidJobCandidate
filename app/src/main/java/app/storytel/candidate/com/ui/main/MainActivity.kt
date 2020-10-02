package app.storytel.candidate.com.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import app.storytel.candidate.com.R
import app.storytel.candidate.com.data.model.Post
import kotlinx.android.synthetic.main.content_scrolling.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val adapter = PostAdapter(this::onPostClick)
    private val observer = Observer<List<Post>> {
        adapter.addItems(it)
        recycler_view.adapter = adapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObservers()
    }

    private fun initObservers() {
        viewModel.postList.observe(this@MainActivity, observer)

    }

    private fun onPostClick(post: Post) {
        // TODO implement navigation to detail screen
    }
}