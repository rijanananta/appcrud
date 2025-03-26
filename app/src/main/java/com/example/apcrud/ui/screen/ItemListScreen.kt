package com.example.apcrud.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.apcrud.viewmodel.AppViewModel
import com.example.apcrud.model.Item

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemListScreen(viewModel: AppViewModel, navController: NavController, categoryId: Int) {
    val items by viewModel.getItemsByCategory(categoryId).collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Items") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("addItem/$categoryId") }) {
                Icon(Icons.Default.Add, contentDescription = "Add Item")
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(items) { item ->
                ListItem(headlineText = { Text(item.name) }, supportingText = { Text(item.description) }, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
