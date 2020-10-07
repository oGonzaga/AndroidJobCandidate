package app.storytel.candidate.com.data_remote

import app.storytel.candidate.com.data.model.Comment
import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

interface Services {

    companion object {
        private const val POST_PATH = "/posts"
        private const val PHOTOS_PATH = "/photos"
        private const val COMMENTS_PATH = "posts/{id}/comments"
    }

    @GET(POST_PATH)
    suspend fun getPosts(): List<Post>

    @GET(PHOTOS_PATH)
    suspend fun getPhotos(): List<Photo>

    @GET(COMMENTS_PATH)
    suspend fun getComments(@Path("id") postId: Int): List<Comment>
}