package app.storytel.candidate.com.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import app.storytel.candidate.com.data.Repository
import app.storytel.candidate.com.data.model.Comment
import app.storytel.candidate.com.data_remote.Resource
import app.storytel.candidate.com.data_remote.ResourceList

class PostDetailViewModel(private val repository: Repository) : ViewModel() {

    var postId: Int = 1

    val request: LiveData<ResourceList<Comment>> = liveData {
        emit(Resource.loading(null))
        emit(repository.getComments(postId))
    }
}