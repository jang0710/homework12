package com.example.newsreader

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import com.example.newsreader.databinding.FragmentDetailBinding
import org.w3c.dom.Text

class DetailFragment : Fragment() {
    private lateinit var tv_mainContents: TextView
    private lateinit var newsItem: NewsItem
    private lateinit var tv_titleContents: TextView
    private lateinit var news_mainimage: ImageView
    private lateinit var news_mainTime: TextView
    private lateinit var mainTitle: TextView

    companion object {
        fun newInstnance(newsItem: NewsItem): DetailFragment {
            val fragment = DetailFragment()
            val args = Bundle()
            args.putParcelable("newsItem", newsItem)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        tv_mainContents = view.findViewById(R.id.tv_mainContents)
        tv_titleContents = view.findViewById(R.id.tv_titleContents)
        news_mainimage = view.findViewById(R.id.news_mainimage)
        news_mainTime = view.findViewById(R.id.news_mainTime)
        mainTitle = view.findViewById(R.id.mainTitle)


        newsItem = arguments?.getParcelable("newsItem") ?: NewsItem(0, "","", "", "")

        updateContent(newsItem)

        return view
    }
    fun updateContent(newsItem: NewsItem) {
        tv_mainContents.text = newsItem.nContent
        tv_titleContents.text = newsItem.nTitleContent
        val drawable = ContextCompat.getDrawable(requireContext(), newsItem.nImage)
        news_mainimage.setImageDrawable(drawable)
        news_mainTime.text = newsItem.nTime
        mainTitle.text = newsItem.nTitle

    }
}
