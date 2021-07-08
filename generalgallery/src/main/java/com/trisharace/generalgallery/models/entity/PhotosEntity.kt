package com.trisharace.generalgallery.models.entity

import com.trisharace.generalgallery.models.data.Photos

data class PhotosEntity(
    val id: Int?,
    var offset: Int?,
    val limit: Int?,
    val total: Int?,
    val count: Int?,
    var results: MutableList<PhotoEntity>?
) {

    fun toPhotos() =
        Photos(
            offset,
            limit, total, count, results?.map { it.toPhoto() }?.toMutableList()
        )
}
