package com.example.myanimelist.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.myanimelist.R
import com.example.myanimelist.data.entities.AnimeEntity
import com.example.myanimelist.databinding.ListItemAnimeItemBinding
import com.example.myanimelist.view.utils.UrlUtil

class AnimeListAdapter : ListAdapter<AnimeEntity, RecyclerView.ViewHolder>(ItemsCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AnimeListItemHolder(
            binding = ListItemAnimeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AnimeListItemHolder).bind(currentList[position])
    }


    private class AnimeListItemHolder(
        private val binding: ListItemAnimeItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.no_image_placeholder)
                .circleCrop()

            Glide.with(binding.root.context)
                .load(UrlUtil.getRandomUrl())
                .apply(requestOptions)
                .error(R.drawable.no_image_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.ivAnimePoster)
        }

        fun bind(animeDbEntity: AnimeEntity) {
            binding.apply {
                tvAnimeName.text = animeDbEntity.name
                tvReview.text = animeDbEntity.review
                tvRating.text = animeDbEntity.rating.toString()
            }
        }

    }


    private object ItemsCallback : DiffUtil.ItemCallback<AnimeEntity>() {

        override fun areItemsTheSame(oldItem: AnimeEntity, newItem: AnimeEntity): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: AnimeEntity, newItem: AnimeEntity): Boolean {
            return oldItem == newItem
        }

    }

}