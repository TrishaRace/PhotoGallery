package com.trisharace.generalgallery.models.view

import android.os.Parcelable
import com.trisharace.generalgallery.models.data.Photo
import com.trisharace.generalgallery.models.data.User
import com.trisharace.generalgallery.models.entity.PhotoUrlsEntity
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoView(
    val id: String,
    val description: String?,
    val likes: Int,
    val photoUrls: PhotoUrlsView?,
    val user: User?
) : Parcelable {


    fun toPhoto() =
        Photo(id,  description,likes,photoUrls?.toPhotoUrls(),user)
}
