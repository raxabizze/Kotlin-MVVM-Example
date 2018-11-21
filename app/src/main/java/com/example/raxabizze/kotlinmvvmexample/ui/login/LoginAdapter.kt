package com.example.raxabizze.kotlinmvvmexample.ui.login

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.raxabizze.kotlinmvvmexample.databinding.ItemLoginBinding
import com.example.raxabizze.kotlinmvvmexample.utils.api.pojo.post.Post

class LoginAdapter(private var items: List<Post>,
                   private var listener: LoginContract.View.OnItemClickListener)
    : RecyclerView.Adapter<LoginAdapter.ViewHolder>(), LoginContract.Adapter {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemLoginBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
            = holder.bind(items[position], listener)

    override fun getItemCount(): Int = items.size

    override fun replaceData(mDataList: List<Post>) {
        items = mDataList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: ItemLoginBinding) :
            RecyclerView.ViewHolder(binding.root) {

        fun bind(post: Post, listener: LoginContract.View.OnItemClickListener?) {
            binding.post = post
            if (listener != null) {
                binding.root.setOnClickListener { _ -> listener.onItemClick(layoutPosition) }
            }

            binding.executePendingBindings()
        }
    }

}

