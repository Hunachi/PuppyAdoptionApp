/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.detail.DetailScreen
import com.example.androiddevchallenge.ui.home.HomeScreen
import com.example.androiddevchallenge.ui.theme.PuppyAdoptionAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val applicationWidth = applicationContext.resources.displayMetrics.let { it.widthPixels / it.density }
            PuppyAdoptionAppTheme {
                MainScreen(applicationWidth)
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(applicationWidth: Float) {
    Surface(color = MaterialTheme.colors.background) {
        MainScreen(applicationWidth = applicationWidth)
    }
}

@Composable
fun MainScreen(applicationWidth: Float) {
    val navController = rememberNavController()

    Column {
        NavHost(navController, startDestination = "home") {
            composable("home") { HomeScreen(navController) }
            composable(
                "detail/{animalId}",
                arguments = listOf(navArgument("animalId") { type = NavType.IntType })
            ) { backStackEntry ->
                val animalId = backStackEntry.arguments
                    ?.getInt("animalId", 0) ?: throw IllegalAccessError()
                DetailScreen(navController, animalId, applicationWidth)
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    PuppyAdoptionAppTheme {
        MyApp(0f)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    PuppyAdoptionAppTheme(darkTheme = true) {
        MyApp(0f)
    }
}
