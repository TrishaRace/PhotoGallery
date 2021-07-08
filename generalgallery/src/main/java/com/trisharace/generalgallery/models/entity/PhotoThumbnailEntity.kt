package com.trisharace.generalgallery.models.entity

import com.trisharace.generalgallery.models.data.PhotoThumbnail

data class PhotoThumbnailEntity(val path: String?, val extension: String?, val image: String?) {

    fun toPhotoThumbnail() = PhotoThumbnail(path, extension, image)
}
