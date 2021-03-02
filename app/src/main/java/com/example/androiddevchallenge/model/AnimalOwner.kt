package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.example.androiddevchallenge.R

data class AnimalOwner(
    val name: String,
    @IdRes @DrawableRes val imageRes: Int = R.drawable.owner_icon2,
    val phone: String = "000-0000-0000",
    val email: String = "hanahanahunachi@gmail.com",
    val greetingMessage: String = "Hello! Please feel free to contact me."
)
