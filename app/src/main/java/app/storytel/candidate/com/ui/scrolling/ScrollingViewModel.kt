package app.storytel.candidate.com.ui.scrolling

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import app.storytel.candidate.com.data.Repository
import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.Resource

class ScrollingViewModel(private val repository: Repository) : ViewModel() {

    val postList: LiveData<Resource<List<Post>>> = liveData {
        emit(Resource.loading(null))
        emit(repository.getPosts())
    }
    val photosList: LiveData<Resource<List<Photo>>> = liveData {
        emit(Resource.loading(null))
        emit(repository.getPhotos())
    }

}