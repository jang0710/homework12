package com.example.newsreader

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.newsreader.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.newsTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.id) {
                    R.id.news_tab_left -> {
                        val titleFragment = TitleFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.news_Frame, titleFragment).commit()
                    }

                    R.id.news_tab_right -> {
                        val detailFragment = DetailFragment()
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.news_Frame, detailFragment).commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })

        // 기본 탭 설정
        val initialTab = binding.newsTablayout.getTabAt(0)
        initialTab?.select()

        if (savedInstanceState == null) {
            if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                val titleFragment = TitleFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.news_Frame, titleFragment)
                    .commit()
            } else {
                val titleFragment = TitleFragment()
                val detailFragment = DetailFragment()

                supportFragmentManager.beginTransaction()
                    .replace(R.id.news_Frame, titleFragment)
                    .replace(R.id.fragment_container, detailFragment).commit()
            }
        }
    }

    // showDetailFragment() 함수를 수정합니다.
    fun showDetailFragment() {
        val detailFragment = DetailFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.news_Frame, detailFragment)
            .addToBackStack(null)
            .commit()
    }
}