package com.example.androiddevchallenge.model

data class SameAnimalsInfo(
    val animalType: AnimalType,
    val animals: List<AnimalInfo> = listOf()
)
