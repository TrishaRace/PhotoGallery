package com.trisharace.photogallery.generalGallery.photoGalleryList

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trisharace.core.extensions.viewBinding
import com.trisharace.core.platform.BaseFragment
import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.photogallery.R
import com.trisharace.photogallery.databinding.FragmentPhotoGalleryBinding
import com.trisharace.photogallery.generalGallery.photoGalleryList.adapters.PhotoGalleryAdapter
import kotlinx.android.synthetic.main.navigation_activity.*
import org.koin.android.viewmodel.ext.android.viewModel


class PhotoGalleryFragment : BaseFragment(R.layout.fragment_photo_gallery) {

    private val binding by viewBinding<FragmentPhotoGalleryBinding>()
    private val photoViewModel by viewModel<PhotoGalleryViewModel>()
    private val photosAdapter by lazy { PhotoGalleryAdapter() }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().toolbar.title = "Bienvenido a App Gallery"
        with(photoViewModel) {
            photos.observe(viewLifecycleOwner, ::handlePhotos)
            showSpinner.observe(viewLifecycleOwner, ::showLoading)
            failure.observe(viewLifecycleOwner, ::showError)
        }
        initView()
        initListeners()
        getData()

    }

    private fun initView() {
        binding.photoList.apply {
            layoutManager = GridLayoutManager(requireContext(),2, RecyclerView.VERTICAL, false)
            adapter = photosAdapter
        }
    }

    private fun initListeners() {
        photosAdapter.photoListener = { photoView ->
            findNavController().navigate(
                PhotoGalleryFragmentDirections.actionPhotoGalleryFragmentToPhotoDetailFragment(
                    photoView
                )
            )
        }
    }

    private fun getData() {
        photoViewModel.getPhotos()
    }

    private fun handlePhotos(photosView: List<PhotoView>) {
        photosView.let {
            val list = photosAdapter.collection.toMutableList()
            list.addAll(it.toMutableList())
            photosAdapter.collection = list
        }
    }

}