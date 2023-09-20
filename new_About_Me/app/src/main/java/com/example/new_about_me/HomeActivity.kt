package com.example.new_about_me

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val id = findViewById<TextView>(R.id.tv_id)
        val name = findViewById<TextView>(R.id.tv_name)
        val mbti = findViewById<TextView>(R.id.tv_mbti)
        val age = findViewById<TextView>(R.id.tv_age)

        if (intent.hasExtra("id") || (intent.hasExtra("name") || (intent.hasExtra("age") || (intent.hasExtra("mbti"))))) {
            val idtext = getString(R.string.tv_idtext) + intent.getStringExtra("id")
            val nametext = getString(R.string.tv_name) + intent.getStringExtra("name")
            val agetext = getString(R.string.tv_age) + intent.getStringExtra("age")
            val mbtitext = getString(R.string.mbti_infp) + intent.getStringExtra("mbti")
            id.text = idtext
            name.text = nametext
            mbti.text = mbtitext
            age.text = agetext
            Log.d("HomeActivity", "intent = ${intent.getStringExtra("name")}")
        }

        val close = findViewById<Button>(R.id.btn_close)
        close.setOnClickListener {
            finish()
        }
        val iv_image = findViewById<ImageView>(R.id.iv_titleimage2)

        val homeimage = when((1..6).random()) {
            1 -> R.drawable.sample_2
            2 -> R.drawable.sample_3
            3 -> R.drawable.sample_4
            4 -> R.drawable.sample_5
            5 -> R.drawable.sample_6
            else -> R.drawable.sample_2
        }
        iv_image.setImageDrawable(ResourcesCompat.getDrawable(resources,homeimage,null))
    }
}