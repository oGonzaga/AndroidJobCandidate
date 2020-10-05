package app.storytel.candidate.com.data

import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.PostServices
import app.storytel.candidate.com.data_remote.Resource
import app.storytel.candidate.com.data_remote.ResponseHandler

class PostRepositoryImpl(
    private val postServices: PostServices,
    private val responseHandler: ResponseHandler = ResponseHandler()
) : PostRepository {
    override suspend fun getPosts(): Resource<List<Post>> {
        return try {
            responseHandler.handleSuccess(postServices.getPosts())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun getPhotos(): Resource<List<Photo>> {
        return try {
            responseHandler.handleSuccess(postServices.getPhotos())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}