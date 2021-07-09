package com.trisharace.generalgallery.models.entity

import com.google.gson.annotations.SerializedName
import com.trisharace.generalgallery.models.data.Photo
import com.trisharace.generalgallery.models.data.User

data class PhotoEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("description")
    val description: String?,
    @SerializedName("likes")
    val likes: Int,
    @SerializedName("urls")
    val photoUrls: PhotoUrlsEntity?,
    @SerializedName("user")
    val user: User?
) {

    fun toPhoto() =
        Photo(id, description,likes,photoUrls?.toPhotoUrls(),user)
}
