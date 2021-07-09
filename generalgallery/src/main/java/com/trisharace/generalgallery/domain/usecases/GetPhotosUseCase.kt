package com.trisharace.generalgallery.domain.usecases

import com.trisharace.generalgallery.domain.repository.PhotosRepository
import com.trisharace.core.utilities.State
import com.trisharace.core.utilities.usecase.FlowUseCase
import com.trisharace.generalgallery.models.view.PhotoView

class GetPhotosUseCase(private val repository: PhotosRepository) :
    FlowUseCase<State<List<PhotoView>>, Unit>() {

    override fun run(params: Unit?) = repository.getPhotos()

}
