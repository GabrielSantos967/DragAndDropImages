package com.example.interactiveimageboard.uiPackage

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.interactiveimageboard.viewmodel.MainViewModel
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import kotlin.contracts.contract


@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    val viewModel: MainViewModel = viewModel()

    val imagePickerLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickMultipleVisualMedia()) {
        uris: List<Uri> ->
        if (uris.isNotEmpty()){
            viewModel.addImages(uris)
        }
    }
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally)
    {

        Button(onClick = { imagePickerLauncher.launch(androidx.activity.result.PickVisualMediaRequest(
            ActivityResultContracts.PickVisualMedia.ImageOnly))})
        {

            Text("Selecionar Imagens")

        }

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth().weight(1f).border(2.dp, androidx.compose.ui.graphics.Color.Gray), contentAlignment = Alignment.Center)
        {

            viewModel.images.forEach{
                image -> ImageCard(image = image)
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Mensagem de feedback")

    }

}