package app.storytel.candidate.com.ui.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.storytel.candidate.com.R
import app.storytel.candidate.com.data.model.Comment
import kotlinx.android.synthetic.main.comment_item.view.*

class CommentAdapter(private val commentList: List<Comment> = listOf()) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.comment_item, parent, false)
    )


    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        commentList[position].let { holder.bind(it) }
    }

    override fun getItemCount() = if (commentList.isNotEmpty()) 3 else 0

    inner class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(comment: Comment) {
            itemView.apply {
                tvTitle.text = comment.name
                tvDescription.text = comment.body
            }
        }
    }
}