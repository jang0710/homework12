package com.example.newsreader

import android.os.Bundle
import android.util.Log
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



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetailBinding.inflate(inflater,container,false)
        val view = binding.root

        parentFragmentManager.setFragmentResultListener("titlekey",this){key, result ->
            val getItem = result.getParcelableArrayList<NewsItem>("titleitem")
            Log.d("TitleFragment", "detail에서 받는 데이터 ${getItem.toString()}")
            binding.apply {
                if(!getItem.isNullOrEmpty()){

                    mainTitle.text = getItem[0].nTitle
                    newsMainimage.setImageResource(getItem[0].nImage)
                    newsMainTime.text = getItem[0].nTime
                    tvTitleContents.text = getItem[0].nTitleContent
                    tvMainContents.text = getItem[0].nContent
                    getItem.clear()
                }

            }

        }
        return view
    }

}
