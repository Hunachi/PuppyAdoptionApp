package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.model.AnimalInfo
import com.example.androiddevchallenge.ui.home.list.AnimalList
import com.example.androiddevchallenge.ui.theme.PuppyAdoptionAppTheme

@Composable
fun HomeScreen(navController: NavController) {
    PuppyAdoptionAppTheme {
        Column(modifier = Modifier.fillMaxWidth()) {
            TopAppBar(title = { Text(text = "Puppy Adoption App") })
            AnimalList(animals = AnimalInfo.sampleData, onClickItem = {
                navController.navigate("detail/${it.id}")
            })
        }
    }
}