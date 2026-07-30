package com.example.interactiveimageboard.model
import android.net.Uri

data class ImageItem (
    val id: Int,

    val uri: Uri,

    var x: Float = 0f,

    var y: Float = 0f,

    var confirmed: Boolean = false

)