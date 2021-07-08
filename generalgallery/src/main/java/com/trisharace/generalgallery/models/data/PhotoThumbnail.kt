package com.trisharace.generalgallery.models.data

import com.trisharace.generalgallery.models.entity.PhotoThumbnailEntity

data class PhotoThumbnail(val path: String?, val extension: String?, val image: String?) {
    constructor(path: String, extension: String) : this(path, extension, null)
    constructor(image: String) : this(null, null, image)

    fun image() = "$path.$extension"

    fun toPhotoThumbnailEntity() = PhotoThumbnailEntity(path, extension, image)

    companion object {
        fun thumbail(image: String): PhotoThumbnail {
            val imageSplit = image.split(".")
            return PhotoThumbnail(imageSplit[0], imageSplit[1])
        }
    }
}
