package app.storytel.candidate.com.data_remote

import app.storytel.candidate.com.data.model.Post
import retrofit2.http.GET

interface PostServices {

    companion object {
        private const val POST_PATH = "/posts"
        private const val PHOTOS_PATH = "/photos"
        private const val GET_POST_PATH = "posts/{id}/comments"
    }

    @GET(POST_PATH)
    suspend fun getPosts(): List<Post>
}