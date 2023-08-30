package com.example.listapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.databinding.ContactItem1Binding
import com.example.listapp.databinding.ContactItem2Binding
import java.lang.RuntimeException

class MyAdapter(val cItems: MutableList<CallItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
        fun onImage(view: View, position: Int)
    }

    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val adapterLayout: View?
        return when (viewType) {
            CallItem.VIEW_TYPE_LEFT -> {
                val binding =
                    ContactItem1Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ItemViewHolder1(binding)
            }
            CallItem.VIEW_TYPE_RIGHT -> {
                val binding =
                    ContactItem2Binding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ItemViewHolder2(binding)
            }
            else -> throw RuntimeException("알수 없는 뷰 타입")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            CallItem.VIEW_TYPE_LEFT -> {
                val holder1 = holder as ItemViewHolder1
                holder1.name.text = cItems[position].aName
                holder1.ImageView.setImageResource(cItems[position].aIcon)
                holder1.phoneNumber.text = cItems[position].aPhoneNumber
                holder1.ImageView.setOnClickListener {
                    itemClick?.onImage(it, position)
                }
                holder1.phoneNumber.setOnClickListener {
                    itemClick?.onClick(it, position)
                }

            }
            CallItem.VIEW_TYPE_RIGHT -> {
                val holder2 = holder as ItemViewHolder2
                holder2.name2.text = cItems[position].aName
                holder2.ImageView2.setImageResource(cItems[position].aIcon)
                holder2.phoneNumber2.text = cItems[position].aPhoneNumber
                holder2.ImageView2.setOnClickListener {
                    itemClick?.onImage(it, position)
                }
                holder2.phoneNumber2.setOnClickListener {
                    itemClick?.onClick(it, position)
                }

            }
        }
//        holder.itemView.setOnClickListener {
//            itemClick?.onClick(it, position)
//        }
//
//        val contact = cItems[position]
//        when (contact.isfavorite) {
//            CallItem.VIEW_TYPE_LEFT -> {
//                if (holder is ItemViewHolder1) {
//                    holder.name.text = contact.aName
//                    holder.phoneNumber.text = contact.aPhoneNumber
//                    holder.ImageView.setImageResource(contact.aIcon)
//                    holder.setIsRecyclable(false)
//                }
//            }
//            CallItem.VIEW_TYPE_RIGHT -> {
//                if (holder is ItemViewHolder2) {
//                    holder.name2.text = contact.aName
//                    holder.phoneNumber2.text = contact.aPhoneNumber
//                    holder.ImageView2.setImageResource(contact.aIcon)
//                    holder.setIsRecyclable(false)
//                }
//            }
//        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (cItems[position].isfavorite) {
            CallItem.VIEW_TYPE_LEFT
        }
        else {
            CallItem.VIEW_TYPE_RIGHT
        }
    }

    override fun getItemCount(): Int {
        return cItems.size
    }

    inner class ItemViewHolder1(val binding: ContactItem1Binding) :
        RecyclerView.ViewHolder(binding.root) {
        val ImageView = binding.ivCat
        val name = binding.textItem1
        val phoneNumber = binding.textPN
    }

    inner class ItemViewHolder2(val binding: ContactItem2Binding) :
        RecyclerView.ViewHolder(binding.root) {
        val ImageView2 = binding.contactItem2
        val name2 = binding.textItem3
        val phoneNumber2 = binding.textItem4
    }
}