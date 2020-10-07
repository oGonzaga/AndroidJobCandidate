package app.storytel.candidate.com.data

import app.storytel.candidate.com.data.model.Comment
import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data_remote.ResourceList

interface Repository {
    suspend fun getPosts(): ResourceList<Post>
    suspend fun getPhotos(): ResourceList<Photo>
    suspend fun getComments(postId: String): ResourceList<Comment>
}