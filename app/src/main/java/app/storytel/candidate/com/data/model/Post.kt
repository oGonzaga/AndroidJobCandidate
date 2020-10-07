package app.storytel.candidate.com.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val userId: Double? = null,
    val id: Double? = null,
    val title: String? = null,
    val body: String? = null,
    val imageUrl: String? = null
): Parcelable