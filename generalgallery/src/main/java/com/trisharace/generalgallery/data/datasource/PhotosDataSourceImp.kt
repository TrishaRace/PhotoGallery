package com.trisharace.generalgallery.data.datasource

import com.trisharace.generalgallery.models.view.PhotosView
import com.trisharace.generalgallery.data.service.PhotoService
import com.trisharace.generalgallery.models.view.PhotoView
import com.example.exception.Failure
import com.example.platform.NetworkHandler
import com.trisharace.core.utilities.State
import com.trisharace.core.utilities.Success
import com.trisharace.core.utilities.Error
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class PhotosDataSourceImp(
    private val networkHandler: NetworkHandler,
    private val service: PhotoService
) : PhotosDataSource {

    override fun getPhotos(
    ) = flow {
        emit(getPhotosFromService())
    }.catch {
        emit(Error(Failure.Throwable(it)))
    }

    override fun getPhotoDetail(id: String) = flow {
        emit(getPhotoDetailFromService(id))
    }.catch {
        emit(Error(Failure.Throwable(it)))
    }

    private suspend fun getPhotosFromService(): State<PhotosView> {
        return if (networkHandler.isConnected == true) {
            service.getPhotos(10, 0).run {
                if (this.isSuccessful && this.body() != null) {
                    val data = this.body()!!.data
                    Success(data.toPhotos().toPhotosView())
                } else {
                    Error(Failure.ServerError(code()))
                }
            }
        } else {
            Error(Failure.NetworkConnection)
        }
    }

    private suspend fun getPhotoDetailFromService(id:String): State<PhotoView> {
        return if (networkHandler.isConnected == true) {
            service.getPhotoDetail(id).run {
                if (this.isSuccessful && this.body() != null) {
                    this.body()!!.data.results?.let {
                        Success(it.first().toPhoto().toPhotoView())
                    }?: kotlin.run {
                        Error(Failure.CustomError(0, "Couldn't get the character"))
                    }
                } else {
                    Error(Failure.ServerError(code()))
                }
            }
        } else {
            Error(Failure.NetworkConnection)
        }
    }
}