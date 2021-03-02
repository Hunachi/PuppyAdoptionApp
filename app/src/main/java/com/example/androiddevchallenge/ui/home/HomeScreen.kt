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
            AnimalList(
                animals = AnimalInfo.sampleData,
                onClickItem = {
                    navController.navigate("detail/${it.id}")
                }
            )
        }
    }
}
