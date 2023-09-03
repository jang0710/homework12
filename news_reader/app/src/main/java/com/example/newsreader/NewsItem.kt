package com.example.newsreader

import android.os.Bundle
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsItem(
    val nImage: Int,
    val nTitle: String,
    val nTitleContent: String,
    val nContent: String,
    val nTime: String
) : Parcelable