package app.storytel.candidate.com.ui.scrolling

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.storytel.candidate.com.R
import app.storytel.candidate.com.data.model.Photo
import app.storytel.candidate.com.data.model.Post
import app.storytel.candidate.com.data.model.PostAndImages
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter(
    private val onPostClick: (post: Post) -> Unit) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private val mPostList: MutableList<Post> = mutableListOf()
    private val mPhotoList: MutableList<Photo> = mutableListOf()

    fun addItems(postAndImage: PostAndImages?) {
        mPostList.addAll(postAndImage?.posts!!)
        mPhotoList.addAll(postAndImage.photos!!)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
    )

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        mPostList[position].let { holder.bind(it, mPhotoList[position]) }
    }

    override fun getItemCount() = mPostList.size

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(post: Post, photo: Photo) {
            itemView.apply {
                title.text = post.title
                body.text = post.body
                Glide.with(this)
                    .load(photo.thumbnailUrl)
                    .placeholder(R.drawable.ic_baseline_image)
                    .into(image)
                setOnClickListener {
                    onPostClick(post)
                }
            }
        }
    }
}