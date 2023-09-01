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
import java.text.DecimalFormat

class AppleAdapter(val appleItems: MutableList<MyItem>) :
    RecyclerView.Adapter<AppleAdapter.AppleItems>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    interface ItemLongClick {
        fun onLongClick(view: View, position: Int)
    }

    var itemClick: ItemClick? = null
    var itemLongClick: ItemLongClick? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppleItems {
        val binding = AppleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AppleItems(binding)
    }


    override fun onBindViewHolder(holder: AppleItems, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.itemView.setOnLongClickListener() OnLongClickListener@ {
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }
        holder.image.setImageResource(appleItems[position].aImage)
        holder.name.text = appleItems[position].aName
        holder.address.text = appleItems[position].aAddress
        val price = appleItems[position].aPrice
        holder.price.text = DecimalFormat("#,###").format(price) + "원"
        holder.bubbletext.text = appleItems[position].aChat.toString()
        holder.hearttext.text = appleItems[position].InterestCnt.toString()

        if (appleItems[position].aLike)
            holder.heartImage.setImageResource(R.drawable.redheart2)
        else
            holder.heartImage.setImageResource(R.drawable.heart_image)

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getItemCount(): Int {
        return appleItems.size
    }

    inner class AppleItems(val binding: AppleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val image = binding.ivSampleimage
        val name = binding.tvName
        val address = binding.tvAddress
        val price = binding.tvPrice
        val bubbletext = binding.tvSpbubble
        val hearttext = binding.tvHearttext
        val heartImage = binding.tvHeart

    }
}



