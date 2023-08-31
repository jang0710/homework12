package com.example.applemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.databinding.ActivityDetailBinding
import com.example.applemarket.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val selectedItem = intent.getParcelableExtra<MyItem>("selected_item")

        binding.tvItemName.text = selectedItem?.aName
        binding.tvSellername.text = selectedItem?.aSeller
        binding.tvSalesDetails.text = selectedItem?.aSalesDetail
        binding.tvDetailprice.text = selectedItem?.aPrice
        binding.tvDetailAddress.text = selectedItem?.aAddress
        binding.ivSampleitem.setImageResource(selectedItem?.aImage ?: 0)

        val btn_back = findViewById<ImageView>(R.id.btn_back)
        btn_back.setOnClickListener {
            onBackPressed()

            Toast.makeText(this, "메인으로 돌아옴", Toast.LENGTH_SHORT).show()
        }
    }
}