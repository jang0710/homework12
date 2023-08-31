package com.example.applemarket

import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityDetailBinding
import com.example.applemarket.databinding.AppleItemBinding
import java.lang.RuntimeException

class AppleAdapter(val appleItems: MutableList<MyItem>) :
    RecyclerView.Adapter<AppleAdapter.AppleItems>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppleItems {
        val binding = AppleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppleItems(binding)
    }


    override fun onBindViewHolder(holder: AppleItems, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.image.setImageResource(appleItems[position].aImage)
        holder.name.text = appleItems[position].aName
        holder.address.text = appleItems[position].aAddress
        holder.price.text = appleItems[position].aPrice
        holder.bubble.text = appleItems[position].aChat.toString()
        holder.heart.text = appleItems[position].aLike.toString()

    }


    override fun getItemCount(): Int {
        return appleItems.size
    }

    inner class AppleItems(val binding: AppleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivSampleimage
        val name = binding.tvName
        val address = binding.tvAddress
        val price = binding.tvPrice
        val bubble = binding.tvSpbubble
        val heart = binding.tvHeart
    }

}



