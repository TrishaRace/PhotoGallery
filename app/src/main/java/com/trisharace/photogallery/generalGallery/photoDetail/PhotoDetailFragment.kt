package com.trisharace.photogallery.generalGallery.photoDetail

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.core.extensions.viewBinding
import com.trisharace.core.platform.BaseFragment
import com.trisharace.photogallery.R
import com.trisharace.photogallery.databinding.FragmentPhotoDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel

class PhotoDetailFragment : BaseFragment(R.layout.fragment_photo_detail) {

    private val binding by viewBinding<FragmentPhotoDetailBinding>()
    private val arguments by navArgs<PhotoDetailFragmentArgs>()
    private val photoDetailViewModel by viewModel<PhotoDetailViewModel>()


    private val photo by lazy(LazyThreadSafetyMode.NONE) { arguments.photo }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(photoDetailViewModel) {
            photoDetail.observe(viewLifecycleOwner, ::handlePhoto)
            showSpinner.observe(viewLifecycleOwner, ::showLoading)
            failure.observe(viewLifecycleOwner, ::showError)
        }
        photoDetailViewModel.getPhotoDetail(photo.id)
    }

    private fun handlePhoto(photoDetail: PhotoView){
        with(binding) {
            with(image) {
                com.bumptech.glide.Glide.with(context.applicationContext)
                    .load(photoDetail.photoUrls?.regular)
                    .transition(com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade())
                    .into(this)
            }
            username.text = photoDetail.user?.username
            description.text = photoDetail.description
            likes.text = photoDetail.likes.toString()
        }
    }
}

