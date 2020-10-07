package app.storytel.candidate.com.data.model

data class Comment(
    var postId: Int? = null,
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var body: String? = null
)