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
package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import com.example.androiddevchallenge.R

data class AnimalInfo(
    val id: Int = 0,
    val name: String = "No Name",
    val age: Int = 0,
    @IdRes @DrawableRes val thumbnailRes: Int = R.drawable.owner_icon2,
    val images: List<AnimalImage> = listOf(
        AnimalImage(),
        AnimalImage(),
        AnimalImage(),
        AnimalImage()
    ),
    val animalType: AnimalType = AnimalType.CAT,
    val description: String = "This is description ....",
    val owner: AnimalOwner = AnimalOwner("hunachi")
) {

    val debugName: String
        get() = "$id $name"

    companion object {

        var sampleId = 0
            get() {
                return field++
            }

        val sampleData = listOf(
            AnimalInfo(
                id = sampleId,
                name = "しまこ",
                thumbnailRes = R.drawable.cat1_t,
                images = listOf(AnimalImage(R.drawable.cat1_0), AnimalImage(R.drawable.cat1_1)),
                animalType = AnimalType.CAT,
                description = "しましま模様がかわいい猫ちゃんです．\n人懐っこいです．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "もふ",
                thumbnailRes = R.drawable.cat2_t,
                images = listOf(AnimalImage(R.drawable.cat2_0)),
                age = 1,
                animalType = AnimalType.CAT,
                description = "しましま模様がかわいい猫ちゃんです．\nもふもふしています．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "しろ",
                thumbnailRes = R.drawable.cat3_t,
                images = listOf(
                    AnimalImage(R.drawable.cat3_0),
                    AnimalImage(R.drawable.cat3_1),
                    AnimalImage(R.drawable.cat3_2),
                    AnimalImage(R.drawable.cat3_3)
                ),
                animalType = AnimalType.CAT,
                description = "もふもふです．おとなしいかわいい子です．",
                owner = AnimalOwner("ふなち")
            ),
            AnimalInfo(
                id = sampleId,
                name = "しまお",
                thumbnailRes = R.drawable.cat4_t,
                images = listOf(AnimalImage(R.drawable.cat4_0)),
                animalType = AnimalType.CAT,
                description = "たくさん食べます．",
                owner = AnimalOwner("ふなち")
            ),
            AnimalInfo(
                id = sampleId,
                name = "たま",
                thumbnailRes = R.drawable.cat5_t,
                images = listOf(AnimalImage(R.drawable.cat5_0)),
                animalType = AnimalType.CAT,
                description = "いつも縁側でひなたぼっこをしています." +
                    "ちょうちょが大好きで春になると庭で追いかけっこをしています．寝顔がかわいい猫ちゃんです．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "ちゃちゃ",
                thumbnailRes = R.drawable.cat6_t,
                images = listOf(AnimalImage(R.drawable.cat6_0)),
                animalType = AnimalType.CAT,
                description = "かわいい猫ちゃんです．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "きゅむ",
                thumbnailRes = R.drawable.cat7_t,
                images = listOf(AnimalImage(R.drawable.cat7_0), AnimalImage(R.drawable.cat7_1)),
                animalType = AnimalType.CAT,
                description = "うるうるした目がかわいい猫ちゃんです．",
                owner = AnimalOwner("ふなち")
            ),
            AnimalInfo(
                id = sampleId,
                name = "ふさこ",
                thumbnailRes = R.drawable.cat8_t,
                images = listOf(AnimalImage(R.drawable.cat8_0)),
                animalType = AnimalType.CAT,
                description = "もふもふしてます．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "おっちゃねこ",
                thumbnailRes = R.drawable.cat9_t,
                images = listOf(AnimalImage(R.drawable.cat9_0), AnimalImage(R.drawable.cat9_1)),
                animalType = AnimalType.CAT,
                description = "お茶大に住んでいます．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "ちょこ太",
                thumbnailRes = R.drawable.dog1_t,
                images = listOf(AnimalImage(R.drawable.dog1_0), AnimalImage(R.drawable.dog1_1)),
                animalType = AnimalType.DOG,
                description = "パピヨンとシーズーの雑種．ふわふわの毛並みと大きな耳が特徴的です．噛まないいい子です．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "おさかなさん1号",
                thumbnailRes = R.drawable.fish1_t,
                images = listOf(AnimalImage(R.drawable.fish1_0), AnimalImage(R.drawable.fish1_1)),
                animalType = AnimalType.FISH,
                description = "赤い綺麗な色をしています．",
                owner = AnimalOwner("Hunachi", imageRes = R.drawable.owner_icon)
            ),
            AnimalInfo(
                id = sampleId,
                name = "おさかなさん2号",
                thumbnailRes = R.drawable.fish2_t,
                images = listOf(AnimalImage(R.drawable.fish2_0), AnimalImage(R.drawable.fish2_1)),
                animalType = AnimalType.FISH,
                description = "大きな口をあけて餌を食べます．",
                owner = AnimalOwner("ふなち")
            ),
            AnimalInfo(
                id = sampleId,
                name = "ぽてと",
                thumbnailRes = R.drawable.mor_t,
                images = listOf(AnimalImage(R.drawable.mor1_0)),
                animalType = AnimalType.MORMOT,
                description = "じっとみつめてきます．",
                owner = AnimalOwner("ふなち")
            )
        )
    }
}
