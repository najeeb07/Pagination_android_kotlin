package com.najeebappdev.dogs.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.najeebappdev.dogs.Data.Dogs
import com.najeebappdev.dogs.databinding.EachRowBinding


class DogsAdapter : PagingDataAdapter<Dogs, DogsAdapter.DogsViewHolder>(Diff()) {

    override fun onBindViewHolder(holder: DogsViewHolder, position: Int) {
        val dogs = getItem(position)
        if (dogs != null) {
            holder.binds(dogs)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogsViewHolder =
        DogsViewHolder(
            EachRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    class DogsViewHolder(private val binding: EachRowBinding) : RecyclerView.ViewHolder(binding.root) {
        fun binds(dogs: Dogs) {
            binding.apply {
                image.load(dogs.url)
            }
        }
    }

    class Diff : DiffUtil.ItemCallback<Dogs>() {
        override fun areItemsTheSame(oldItem: Dogs, newItem: Dogs): Boolean =
            oldItem.url == newItem.url

        override fun areContentsTheSame(oldItem: Dogs, newItem: Dogs): Boolean =
            oldItem == newItem
    }
}