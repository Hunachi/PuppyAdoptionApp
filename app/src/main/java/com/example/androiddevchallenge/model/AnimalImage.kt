package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.example.androiddevchallenge.R

data class AnimalImage(
    @IdRes @DrawableRes val imageRes: Int = R.drawable.owner_icon2,
    val caption: String = "元気に遊んでいるところ"
)
