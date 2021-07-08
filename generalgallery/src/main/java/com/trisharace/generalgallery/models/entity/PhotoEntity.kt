package com.trisharace.generalgallery.models.entity

import com.trisharace.generalgallery.models.data.Photo

data class PhotoEntity(
    val id: Int,
    val name: String?,
    val description: String?,
    val modified: String?,
    val resourceURI: String?,
    val thumbnail: PhotoThumbnailEntity?
) {

    fun toPhoto() =
        Photo(id, name, description, modified, resourceURI, thumbnail?.toPhotoThumbnail())
}
