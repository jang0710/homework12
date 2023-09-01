package com.example.newsreader

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsItem (
    val title:String, val article : String
) : Parcelable