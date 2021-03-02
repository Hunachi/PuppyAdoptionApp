package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.AnimalInfo
import com.example.androiddevchallenge.ui.theme.PuppyAdoptionAppTheme

@Composable
fun DetailScreen(navController: NavController, animalId: Int, applicationWidth: Float) {
    PuppyAdoptionAppTheme {
        val animalInfo = AnimalInfo.sampleData.find { it.id == animalId }
        if (animalInfo != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                TopAppBar(title = { Text(text = animalInfo.name) })
                DetailHeader(animalInfo = animalInfo, applicationWidth)
                SmallOwner(owner = animalInfo.owner)
                DetailBody(animalInfo = animalInfo)
            }
        } else {
            Text(text = "Error!")
        }
    }
}

@Composable
fun DetailHeader(animalInfo: AnimalInfo, applicationWidth: Float) {
    Box(modifier = Modifier.fillMaxWidth()) {
        LazyRow {
            items(animalInfo.images) {
                val image = painterResource(id = it.imageRes)
                val imageModifier =
                    Modifier
                        .requiredHeight(300.dp)
                        .requiredWidth(applicationWidth.dp)
                Image(
                    image,
                    contentDescription = null,
                    modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
    Text(
        text = animalInfo.name,
        style = MaterialTheme.typography.h4,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp)
    )
}

@Composable
fun DetailBody(animalInfo: AnimalInfo) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .fillMaxWidth()
    ) {
        // Text(text = animalInfo.animalType.name)
        Text(text = " " + animalInfo.age.toString() + " years old")
        Text(text = animalInfo.description)
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    PuppyAdoptionAppTheme {
        val naviController = rememberNavController()
        DetailScreen(navController = naviController, animalId = 0, 200f)
    }
}
