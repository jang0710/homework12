package com.example.newsreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newsreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.apply {
        }
    }
}