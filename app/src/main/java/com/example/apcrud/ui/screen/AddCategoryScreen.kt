package com.example.apcrud.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.apcrud.viewmodel.AppViewModel
import com.example.apcrud.model.Category

@Composable
fun AddCategoryScreen(viewModel: AppViewModel, onCategoryAdded: () -> Unit) {
    var name by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("com.example.apcrud.model.Category Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                if (name.isNotBlank()) {
                    viewModel.insertCategory(Category(name = name))
                    onCategoryAdded()
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add com.example.apcrud.model.Category")
        }
    }
}
