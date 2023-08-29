package com.example.listapp

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<CallItem>()
        dataList.add(CallItem(R.drawable.sample_0, "철수", "010-1234-5678", 0))
        dataList.add(CallItem(R.drawable.sample_1, "영희", "010-9012-3456", 1))
        dataList.add(CallItem(R.drawable.sample_2, "민수", "010-7890-1234", 0))
        dataList.add(CallItem(R.drawable.sample_3, "민희", "010-5678-9012", 1))
        dataList.add(CallItem(R.drawable.sample_4, "광수", "010-3456-7890", 0))
        dataList.add(CallItem(R.drawable.sample_5, "숙희", "010-9876-5432", 1))
        dataList.add(CallItem(R.drawable.sample_6, "진수", "010-1098-7654", 0))
        dataList.add(CallItem(R.drawable.sample_7, "명희", "010-3210-9876", 1))
        dataList.add(CallItem(R.drawable.sample_8, "성수", "010-5432-1098", 0))
        dataList.add(CallItem(R.drawable.sample_9, "나희", "010-7654-3210", 1))


        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)


        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                val phone: String = dataList[position].aPhoneNumber
                // Intent를 이용해서 다이얼에 전화번호정보를 출력시킴
                val intnet = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                startActivity(intnet)
            }
        }
    }
}
