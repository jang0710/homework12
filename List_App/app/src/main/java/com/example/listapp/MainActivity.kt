package com.example.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.listapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<CallItem>()
        dataList.add(CallItem(R.drawable.sample_0, "철수", "010-1234-5678"))
        dataList.add(CallItem(R.drawable.sample_1, "영희", "010-9012-3456"))
        dataList.add(CallItem(R.drawable.sample_2, "민수", "010-7890-1234"))
        dataList.add(CallItem(R.drawable.sample_3, "민희", "010-5678-9012"))
        dataList.add(CallItem(R.drawable.sample_4, "광수", "010-3456-7890"))
        dataList.add(CallItem(R.drawable.sample_5, "숙희", "010-9876-5432"))
        dataList.add(CallItem(R.drawable.sample_6, "진수", "010-1098-7654"))
        dataList.add(CallItem(R.drawable.sample_7, "명희", "010-3210-9876"))
        dataList.add(CallItem(R.drawable.sample_8, "성수", "010-5432-1098"))
        dataList.add(CallItem(R.drawable.sample_9, "나희", "010-7654-3210"))
    }
}