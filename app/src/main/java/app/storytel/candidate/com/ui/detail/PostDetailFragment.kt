package app.storytel.candidate.com.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import app.storytel.candidate.com.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_post_detail.*

class PostDetailFragment : Fragment() {

    private val args: PostDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_post_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupView()
    }

    private fun setupView() {
        args.post.let {
            details.text = it.title
                Glide.with(this)
                    .load(it.imageUrl)
                    .placeholder(R.drawable.ic_baseline_android)
                    .into(backdrop)
        }
    }
}