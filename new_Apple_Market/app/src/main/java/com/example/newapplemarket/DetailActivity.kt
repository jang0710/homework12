package com.example.newapplemarket

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.newapplemarket.databinding.ActivityDetailBinding
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var isLike = false
    private val item: MyItem? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(Constants.ITEM_OBJECT, MyItem::class.java)
        } else {
            intent.getParcelableExtra(Constants.ITEM_OBJECT)
        }
    }
    private val itemPosition: Int by lazy {
        intent.getIntExtra(Constants.ITEM_INDEX,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivSampleitem.setImageDrawable(item?.let {
            ResourcesCompat.getDrawable(resources, it.aImage, null)
        })
        isLike = item?.aLike == true
        binding.tvSellername.text = item?.aSeller
        binding.tvDetailAddress.text = item?.aAddress
        binding.tvItemName.text = item?.aName
        binding.tvSalesDetails.text = item?.aSalesDetail
        binding.tvDetailprice.text = DecimalFormat("#,###").format(item?.aPrice) + "원"
        binding.ivHeart.setImageResource(if (isLike) {R.drawable.redheart1}else{R.drawable.heart_image2})
        binding.btnBack.setOnClickListener {
            exit()
        }
        binding.ivHeart.setOnClickListener {
            if (!isLike) {
                binding.ivHeart.setImageResource(R.drawable.redheart1)
                Snackbar.make(binding.constLayout, "관심 목록에 추가되었습니다.", Snackbar.LENGTH_SHORT).show()
                isLike = true
            }else {
                binding.ivHeart.setImageResource(R.drawable.heart_image2)
                isLike = false
            }
        }
    }
    fun exit() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("itemIndex",itemPosition)
            putExtra("aLike", isLike)
        }
        setResult(RESULT_OK, intent)
        finish()
    }

    override fun onBackPressed() {
        exit()
    }
}