package app.storytel.candidate.com.ui.scrolling

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import app.storytel.candidate.com.data.Repository
import app.storytel.candidate.com.data.model.PostAndImages
import app.storytel.candidate.com.data_remote.Resource
import app.storytel.candidate.com.data_remote.model.Status

class ScrollingViewModel(private val repository: Repository) : ViewModel() {

    private val request = MutableLiveData<Unit>().apply {
        postValue(Unit)
    }

    private suspend fun retrievePostAndImages(): Resource<PostAndImages> {
        val post = repository.getPosts()
        val photos = repository.getPhotos()
        return if (post.status == Status.SUCCESS && photos.status == Status.SUCCESS) {
            Resource(
                status = Status.SUCCESS,
                data = PostAndImages(
                    posts = post.data,
                    photos = photos.data,
                ),
                message = null
            )
        } else {
            Resource.error("error", null)
        }
    }

    val getPostAndPhotos = request.switchMap {
        liveData {
            emit(Resource.loading(null))
            emit(retrievePostAndImages())
        }
    }

    fun request() = request.postValue(Unit)

}