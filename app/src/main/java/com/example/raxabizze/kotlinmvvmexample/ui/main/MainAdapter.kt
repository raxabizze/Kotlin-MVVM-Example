package com.example.raxabizze.kotlinmvvmexample.ui.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.raxabizze.kotlinmvvmexample.databinding.ItemMainBinding
import com.example.raxabizze.kotlinmvvmexample.room.Posts
import com.example.raxabizze.kotlinmvvmexample.utils.api.pojo.post.Post

class MainAdapter(private var items: List<Posts>,
                  private var listener: MainContract.View.OnItemClickListener)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>(), MainContract.Adapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    override fun replaceData(mDataList: List<Posts>) {
        items = mDataList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: ItemMainBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(posts: Posts, listener: MainContract.View.OnItemClickListener?) {
            var post = Post(posts.keyid, posts.title, posts.id, posts.userId.toString())
            binding.post = post
            if (listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }

}

