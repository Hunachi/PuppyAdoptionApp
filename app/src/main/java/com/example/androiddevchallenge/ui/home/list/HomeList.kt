package com.example.androiddevchallenge.ui.home.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TabRowDefaults.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.model.AnimalInfo
import com.example.androiddevchallenge.model.SameAnimalsInfo
import com.example.androiddevchallenge.ui.theme.Brawn600
import com.example.androiddevchallenge.ui.theme.Brawn800
import com.example.androiddevchallenge.ui.theme.PuppyAdoptionAppTheme


@Composable
fun AnimalItemView(
    animalInfo: AnimalInfo,
    onClickItem: (AnimalInfo) -> Unit
) {
    val image = painterResource(id = animalInfo.thumbnailRes)
    Column(
        modifier = Modifier
            .clickable { onClickItem(animalInfo) }
            .padding(start = 8.dp, end = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val imageModifier = Modifier
            .requiredHeight(104.dp)
            .requiredWidth(104.dp)
            .clip(shape = RoundedCornerShape(24.dp))
        Image(
            image,
            contentDescription = null,
            modifier = imageModifier.clickable(onClick = { onClickItem(animalInfo) }),
            contentScale = ContentScale.FillHeight
        )
        Text(
            text = animalInfo.name,
            modifier = Modifier
                .padding(top = 8.dp, bottom = 8.dp)
                .widthIn(max = 104.dp),
            style = MaterialTheme.typography.subtitle1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun AnimalList(
    animals: List<AnimalInfo>,
    modifier: Modifier = Modifier,
    onClickItem: (AnimalInfo) -> Unit,
) {
    Box(modifier) {
        LazyColumn(Modifier.fillMaxWidth()) {
            val lists = animals.groupBy { it.animalType }.map { SameAnimalsInfo(it.key, it.value) }
            items(lists) { content ->
                Text(
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp),
                    text = content.animalType.name,
                    style = TextStyle(
                        color = Brawn800,
                        fontSize = 24.sp,
                        fontWeight = FontWeight(700)
                    )
                )
                Box(modifier) {
                    LazyRow {
                        items(content.animals) {
                            AnimalItemView(it, onClickItem)
                        }
                    }
                }
                Divider(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                    color = Brawn600,
                    thickness = 1.dp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    PuppyAdoptionAppTheme {
        AnimalList(animals = AnimalInfo.sampleData, onClickItem = {
            // Nyan~.
        })
    }
}