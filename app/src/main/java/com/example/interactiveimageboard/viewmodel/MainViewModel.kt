package com.example.interactiveimageboard.viewmodel

import android.net.Uri
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.interactiveimageboard.model.ImageItem

class MainViewModel : ViewModel() {
    val images = mutableStateListOf<ImageItem>()

    var feedbackMessage = mutableStateOf("")

    private var nextImageId = 0

    fun addImages(uris: List<Uri>) {
        uris.forEach { uri ->
            images.add(ImageItem(id = nextImageId++, uri = uri))
        }

        feedbackMessage.value = "${uris.size} imagem(ns) adicionada(s)"
    }
}