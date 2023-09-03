package com.example.newsreader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import com.example.newsreader.databinding.FragmentDetailBinding
import org.w3c.dom.Text

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        arguments?.let {
            val newsItem = it.getParcelable<NewsItem>("newsItem")
            binding.mainTitle.text = newsItem?.nTitle
            binding.newsMainimage.setImageDrawable(newsItem?.let {
                ResourcesCompat.getDrawable(resources, it.nImage, null)
            })
            binding.newsMainTime.text = newsItem?.nTime
            binding.tvTitleContents.text = newsItem?.nTitleContent
            binding.tvMainContents.text = newsItem?.nContent
        }
        return view
    }
}
