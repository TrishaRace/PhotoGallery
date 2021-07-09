package com.trisharace.generalgallery.models.data

import com.trisharace.generalgallery.models.entity.PhotoUrlsEntity
import com.trisharace.generalgallery.models.view.PhotoUrlsView

data class PhotoUrls(
    val regular: String?,
    val small: String?,
    val thumb: String?
) {

    fun toPhotoUrlsEntity() = PhotoUrlsEntity(regular, small, thumb)
    fun toPhotoUrlsView() = PhotoUrlsView(regular, small, thumb)

}