package app.storytel.candidate.com.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import app.storytel.candidate.com.data.PostRepository
import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.Resource

class MainViewModel(private val postRepository: PostRepository) : ViewModel() {

    val postList: LiveData<Resource<List<Post>>> = liveData {
        emit(Resource.loading(null))
        emit(postRepository.getPosts())
    }
    val photosList: LiveData<Resource<List<Photo>>> = liveData {
        emit(postRepository.getPhotos())
    }

}