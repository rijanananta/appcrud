@file:Suppress("UNREACHABLE_CODE")

package com.example.apcrud.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apcrud.viewmodel.AppViewModel
import com.example.apcrud.model.Item

@Composable
fun AddItemScreen(viewModel: AppViewModel, categoryId: Int, onItemAdded: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("com.example.apcrud.model.Item Name") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("com.example.apcrud.model.Item Description") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
        Button(
            onClick = {
                if (name.isNotBlank() && description.isNotBlank()) {
                    viewModel.insertItem(Item())
                    onItemAdded()
                }
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add com.example.apcrud.model.Item")
        }
    }
}

fun Item(): Item {

    return TODO("Provide the return value")
}

@Preview(showBackground = true)
@Composable
fun AddItemScreenPreview() {
    // Contoh tampilan tanpa ViewModel untuk preview
}
