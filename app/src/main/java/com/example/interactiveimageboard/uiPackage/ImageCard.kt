package com.example.interactiveimageboard.uiPackage

import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.size
import com.example.interactiveimageboard.model.ImageItem

@Composable
fun ImageCard(image: ImageItem, modifier: Modifier = Modifier.offset(image.x.dp, image.y.dp).size(120.dp)) {
    AsyncImage(model = image.uri, contentDescription = null, modifier = modifier.size(120.dp))

}