package com.example.interactiveimageboard.uiPackage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.size
import com.example.interactiveimageboard.model.ImageItem
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import kotlin.math.roundToInt
import androidx.compose.foundation.clickable
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment

@Composable
fun ImageCard(
    image: ImageItem,
    onClick: () -> Unit,
    onConfirm: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .offset { IntOffset(image.x.roundToInt(), image.y.roundToInt()) }
    ) {

        AsyncImage(
            model = image.uri,
            contentDescription = null,
            modifier = Modifier
                .clickable { if (!image.isLocked){onClick()} }
                .pointerInput(Unit) {
                    detectTransformGestures { _, pan, zoom, _ ->
                        if (image.isSelected && !image.isLocked) {
                            image.x = (image.x + pan.x).coerceIn(-300f, 300f)
                            image.y = (image.y + pan.y).coerceIn(-700f, 700f)
                            image.scale *= zoom
                        }
                    }
                }
                .then(
                    if (image.isSelected && !image.isLocked) {
                        Modifier.border(3.dp, Color.Blue)
                    } else {
                        Modifier
                    }
                )
                .graphicsLayer(
                    scaleX = image.scale,
                    scaleY = image.scale
                )
                .size(120.dp)
        )


        if (image.isSelected) {
            Button(
                onClick = { onConfirm() },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
            ) {
                Text("✓")
            }
        }
    }
}