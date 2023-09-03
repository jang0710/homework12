package com.example.newsreader

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.newsreader.databinding.ActivityMainBinding
import com.example.newsreader.databinding.FragmentDetailBinding
import com.example.newsreader.databinding.FragmentTitleBinding


class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.news_Frame, TitleFragment())
                .commit()
        } else { // 화면이 가로 방향인 경우 TitleFragment와 DetailFragment 동시에 표시
            supportFragmentManager.beginTransaction()
                .replace(R.id.news_Frame, TitleFragment())
                .replace(R.id.detail_news_Frame, DetailFragment())
                .commit()
        }
    }

    // showDetailFragment() 함수를 수정합니다.
    fun showDetailFragment(newsItem: NewsItem) {
        val detailFragment = DetailFragment()
        val bundle = Bundle()
        bundle.putParcelable("newsItem", newsItem)
        detailFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.detail_fragment_container, detailFragment)
            .addToBackStack(null)
            .commit()
    }


}