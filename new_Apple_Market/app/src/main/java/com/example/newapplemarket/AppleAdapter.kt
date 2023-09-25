package com.example.newapplemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newapplemarket.databinding.AppleItemBinding
import java.text.DecimalFormat

class AppleAdapter( val appleItems: MutableList<MyItem> ) : RecyclerView.Adapter<AppleAdapter.AppleItems>() {

    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null
    interface ItemLongClick {
        fun onLongClick(view: View, position: Int)
    }
    var itemLongClick: ItemLongClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppleItems {
        val binding = AppleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AppleItems(binding)
    }

    override fun onBindViewHolder(holder: AppleItems, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it,position)
        }
        holder.itemView.setOnLongClickListener() OnLongClickListener@ {
            itemLongClick?.onLongClick(it, position)
            return@OnLongClickListener true
        }
        holder.image.setImageResource(appleItems[position].aImage)
        holder.name.text = appleItems[position].aName
        holder.address.text = appleItems[position].aAddress
        holder.bubbletext.text = appleItems[position].aChat.toString()
        holder.hearttext.text = appleItems[position].InterestCnt.toString()
        holder.price.text = DecimalFormat("#,###").format(appleItems[position].aPrice) +"원"

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