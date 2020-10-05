package app.storytel.candidate.com.data

import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.Resource

interface PostRepository {
    suspend fun getPosts(): Resource<List<Post>>
    suspend fun getPhotos(): Resource<List<Photo>>
}