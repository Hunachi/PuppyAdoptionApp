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
package com.example.androiddevchallenge.ui.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.AnimalOwner
import com.example.androiddevchallenge.ui.theme.PuppyAdoptionAppTheme

@Composable
fun SmallOwner(owner: AnimalOwner) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 4.dp, bottom = 4.dp)
                    .requiredHeight(48.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Image(
                    painterResource(id = owner.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .requiredHeight(40.dp)
                        .requiredWidth(40.dp)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    contentScale = ContentScale.Inside
                )
            }
            Column(
                modifier = Modifier.requiredHeight(48.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = owner.name,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(top = 4.dp, bottom = 4.dp)
                )
                if (!expanded) {
                    Text(
                        text = owner.greetingMessage,
                        style = MaterialTheme.typography.caption,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.padding(top = 0.dp, bottom = 4.dp)
                    )
                }
            }
        }
        if (expanded) {
            SmallOwnerDetail(owner = owner) {
                expanded = !expanded
            }
        }
    }
}

@Composable
fun SmallOwnerDetail(owner: AnimalOwner, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.padding(top = 4.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painterResource(id = R.drawable.ic_baseline_local_phone_24),
                contentDescription = null,
                modifier = Modifier
                    .requiredHeight(24.dp)
                    .requiredWidth(24.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Inside
            )
            Text(text = owner.phone)
        }
        Row(modifier = Modifier.padding(top = 4.dp)) {
            Image(
                painterResource(id = R.drawable.ic_baseline_email_24),
                contentDescription = null,
                modifier = Modifier
                    .requiredHeight(24.dp)
                    .requiredWidth(24.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Inside
            )
            Text(text = owner.email)
        }
        Text(
            modifier = Modifier.padding(start = 4.dp, top = 4.dp, bottom = 8.dp),
            text = owner.greetingMessage
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OwnerPreview() {
    PuppyAdoptionAppTheme {
        Column(Modifier.fillMaxWidth()) {
            val owner = AnimalOwner("hunachi")
            SmallOwner(owner = owner)
            SmallOwnerDetail(owner = owner) {}
        }
    }
}
