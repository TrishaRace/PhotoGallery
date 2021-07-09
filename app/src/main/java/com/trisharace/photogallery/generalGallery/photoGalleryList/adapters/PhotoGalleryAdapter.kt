package com.trisharace.photogallery.generalGallery.photoGalleryList.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.trisharace.generalgallery.models.view.PhotoView
import com.trisharace.photogallery.R
import com.trisharace.photogallery.databinding.ItemViewPhotoBinding

import kotlin.properties.Delegates

class PhotoGalleryAdapter : RecyclerView.Adapter<PhotoGalleryAdapter.PhotoListViewHolder>() {

    internal var collection: List<PhotoView> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    internal fun clearCollection(){
        collection = emptyList()
    }
    internal var photoListener: (PhotoView) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        PhotoListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_photo, parent, false)
        )


    override fun getItemCount(): Int = collection.size

    override fun onBindViewHolder(holder: PhotoListViewHolder, position: Int) {
        holder.bind(collection[position], photoListener)
    }

    inner class PhotoListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemViewPhotoBinding.bind(itemView)

        fun bind(item: PhotoView, photoListener: (PhotoView) -> Unit) {
            with(binding.image) {
                Glide.with(context.applicationContext)
                    .load(item.photoUrls?.thumb)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(this)
            }
            binding.cardViewItem.setOnClickListener { photoListener(item) }

        }
    }
}
