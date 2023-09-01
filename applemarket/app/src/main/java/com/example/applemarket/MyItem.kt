package com.example.applemarket

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyItem(
    val aImage: Int,
    val aName: String,
    val aSalesDetail: String,
    val aSeller: String,
    val aAddress: String,
    val aPrice: Int,
    var InterestCnt: Int,
    val aChat: Int,
    var aLike: Boolean
) : Parcelable
