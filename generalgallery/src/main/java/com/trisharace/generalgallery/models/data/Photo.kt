package com.trisharace.generalgallery.models.data

import com.google.gson.annotations.SerializedName
import com.trisharace.generalgallery.models.entity.PhotoEntity
import com.trisharace.generalgallery.models.view.PhotoView

data class Photo(
    val id: String,
    val description: String?,
    val likes: Int,
    val photoUrls: PhotoUrls?,
    val user: User?
) {

    fun toPhotoEntity() = PhotoEntity(id, description,likes,photoUrls?.toPhotoUrlsEntity(),user)
    fun toPhotoView() = PhotoView(
        id, description,likes,photoUrls?.toPhotoUrlsView(),user
    )
}
