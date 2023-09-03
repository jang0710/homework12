package com.example.newsreader

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreader.databinding.TitleItemBinding

class NewsAdapter(private val newsItems: MutableList<NewsItem>): RecyclerView.Adapter<NewsAdapter.NewsItems>() {
    interface ItemClick {
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsItems {
        val binding = TitleItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsItems(binding)
    }

    override fun onBindViewHolder(holder: NewsItems, position: Int) {
        holder.itemView.setOnClickListener {
            itemClick?.onClick(it, position)
        }
        holder.title.text = newsItems[position].nTitle
        holder.image.setImageResource(newsItems[position].nImage)
        holder.titleContent.text = newsItems[position].nTitleContent
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }
    inner class NewsItems(val binding: TitleItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val title = binding.newsTitleitem
        val image = binding.newsImageitem
        val titleContent = binding.newsTitleContentsitem
    }
}