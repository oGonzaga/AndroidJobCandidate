package app.storytel.candidate.com.data

import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.PostServices

class PostRepositoryImpl(private val postServices: PostServices) : PostRepository {
    override suspend fun getPosts(): List<Post> = postServices.getPosts()
}