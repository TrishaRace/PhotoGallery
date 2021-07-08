package com.trisharace.generalgallery.models.data

import com.trisharace.generalgallery.models.entity.PhotoEntity
import com.trisharace.generalgallery.models.view.PhotoView

data class Photo(
    val id: Int,
    val name: String?,
    val description: String?,
    val modified: String?,
    val resourceURI: String?,
    val photoImage: PhotoThumbnail?
) {

    fun toPhotoEntity() = PhotoEntity(id, name, description, modified, resourceURI, photoImage?.toPhotoThumbnailEntity())
    fun toPhotoView() = PhotoView(
        id,
        name.orEmpty(),
        description.orEmpty(),
        modified,
        resourceURI.orEmpty(),
        photoImage?.image().orEmpty()
    )
}
