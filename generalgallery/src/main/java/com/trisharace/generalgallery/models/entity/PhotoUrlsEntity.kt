package com.trisharace.generalgallery.models.entity

import com.trisharace.generalgallery.models.data.PhotoUrls

data class PhotoUrlsEntity(
    val regular: String?,
    val small: String?,
    val thumb: String?
) {

    fun toPhotoUrls() = PhotoUrls(regular, small, thumb)

}