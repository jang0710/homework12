package com.example.homework1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val tv_id = findViewById<TextView>(R.id.tv_id)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        val tv_age = findViewById<TextView>(R.id.tv_age)
        val tv_mbti = findViewById<TextView>(R.id.tv_mbti)

        // 연결하다가 만 부분

        if (intent.hasExtra("id")) {
            tv_id.text = "아이디: "+ intent.getStringExtra("id")
        }

        val btn_close = findViewById<Button>(R.id.btn_close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}