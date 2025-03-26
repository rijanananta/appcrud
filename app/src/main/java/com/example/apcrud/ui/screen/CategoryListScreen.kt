package com.example.apcrud.ui.screen
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.apcrud.viewmodel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(viewModel: AppViewModel, navController: NavController) {
    val categories by viewModel.categories.collectAsState(initial = emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("Categories") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("addCategory") }) {
                Icon(Icons.Default.Add, contentDescription = "Add com.example.apcrud.model.Category")
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(categories) { category ->
                ListItem(
                    headlineContent = { Text(category.name) },
                    modifier = Modifier.padding(8.dp),
                    leadingContent = { Icon(Icons.Default.Add, contentDescription = null) }, // Ganti dengan ikon yang sesuai
                    trailingContent = {
                        IconButton(onClick = { /* Tambahkan aksi edit/hapus di sini */ }) {
                            Icon(Icons.Default.Add, contentDescription = "Edit")
                        }
                    }
                )
            }
        }
    }
}
