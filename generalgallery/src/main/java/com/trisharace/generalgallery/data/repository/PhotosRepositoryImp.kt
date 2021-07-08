package com.trisharace.generalgallery.data.repository

import com.trisharace.generalgallery.data.datasource.PhotosDataSource
import com.trisharace.generalgallery.domain.repository.PhotosRepository

class PhotosRepositoryImp(
    private val photosDataSource: PhotosDataSource
) : PhotosRepository {
    override fun getPhotos() = photosDataSource.getPhotos()
    override fun getPhotoDetail(id: String) = photosDataSource.getPhotoDetail(id)

}