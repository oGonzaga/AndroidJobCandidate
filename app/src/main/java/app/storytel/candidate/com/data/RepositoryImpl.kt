package app.storytel.candidate.com.data

import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.Resource
import app.storytel.candidate.com.data_remote.ResponseHandler
import app.storytel.candidate.com.data_remote.Services

class RepositoryImpl(
    private val services: Services,
    private val responseHandler: ResponseHandler = ResponseHandler()
) : Repository {
    override suspend fun getPosts(): Resource<List<Post>> {
        return try {
            responseHandler.handleSuccess(services.getPosts())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }

    override suspend fun getPhotos(): Resource<List<Photo>> {
        return try {
            responseHandler.handleSuccess(services.getPhotos())
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}