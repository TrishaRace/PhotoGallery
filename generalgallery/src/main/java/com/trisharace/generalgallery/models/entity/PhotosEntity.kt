package com.trisharace.generalgallery.models.entity

import com.trisharace.generalgallery.models.data.Photo

data class PhotosEntity(
    val photo: List<PhotoEntity>
) {

    fun toPhotos() : List<Photo> = photo.map { it.toPhoto() }

}
