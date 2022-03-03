package com.kl3jvi.musicapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kl3jvi.musicapp.databinding.ItemMoreFromThisArtistBinding
import com.kl3jvi.musicapp.databinding.ItemMoreFromThisArtistBindingImpl
import com.kl3jvi.musicapp.databinding.ItemMusicBinding
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.presentation.details.DetailsFragmentDirections
import com.kl3jvi.musicapp.presentation.search.SearchFragmentDirections

class MoreAdapter : PagingDataAdapter<Album, MoreAdapter.MusicViewHolder>(MoreDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding: ItemMoreFromThisArtistBinding = ItemMoreFromThisArtistBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bindItem(item)
        }
    }

    inner class MusicViewHolder constructor(
        private val binding: ItemMoreFromThisArtistBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.albumInfo?.let { albumInfo ->
                    navigateToDetails(albumInfo, view)
                }
            }
        }

        private fun navigateToDetails(album: Album, view: View) {
            val direction = DetailsFragmentDirections.actionNavigationDetailsSelf(album)
            view.findNavController().navigate(direction)
        }

        fun bindItem(album: Album) {
            binding.apply {
                albumInfo = album
                executePendingBindings()
            }
        }
    }
}

private class MoreDiffUtil : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.playCount == newItem.playCount
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}