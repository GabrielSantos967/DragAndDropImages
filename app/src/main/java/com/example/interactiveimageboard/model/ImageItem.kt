package com.example.interactiveimageboard.model
import android.net.Uri
import androidx.compose.runtime.MutableFloatState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

data class ImageItem(val id: Int, val uri: Uri) {
    var x by mutableFloatStateOf(0f)
    var y by mutableFloatStateOf(0f)

    var scale by mutableStateOf(1f)

    var isSelected by mutableStateOf(false)

    var isLocked by mutableStateOf(false)
}