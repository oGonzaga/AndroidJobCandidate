package app.storytel.candidate.com.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import app.storytel.candidate.com.data.PostRepository
import app.storytel.candidate.com.data.model.Post

class MainViewModel(private val postRepository: PostRepository) : ViewModel() {

    val postList: LiveData<List<Post>> = liveData {
        emit(postRepository.getPosts())
    }

}