package app.storytel.candidate.com.data

import app.storytel.candidate.com.data.model.Post

interface PostRepository {
    suspend fun getPosts(): List<Post>
}