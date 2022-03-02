package com.kl3jvi.musicapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kl3jvi.musicapp.databinding.ItemMusicBinding
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.presentation.home.HomeFragmentDirections

/**
 * Adapter for the [RecyclerView] in [HomeFragment].
 */

class MusicAdapter : PagingDataAdapter<Album, MusicAdapter.MusicViewHolder>(MusicDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val binding: ItemMusicBinding = ItemMusicBinding.inflate(
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
        private val binding: ItemMusicBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.setClickListener { view ->
                binding.albumInfo?.let { albumInfo ->
                    navigateToDetails(albumInfo, view)
                }
            }
        }

        private fun navigateToDetails(album: Album, view: View) {
            val direction =
                HomeFragmentDirections.actionHomeFragmentToDetailsFragment()
//            view.findNavController().navigate(direction)
        }

        fun bindItem(album: Album) {
            binding.apply {
                albumInfo = album
                executePendingBindings()
            }
        }
    }

}

private class MusicDiffCallback : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.playcount == newItem.playcount
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem == newItem
    }
}
