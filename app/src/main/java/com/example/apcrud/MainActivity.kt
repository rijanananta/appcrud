package com.example.apcrud.data

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.apcrud.ui.theme.ApcrudTheme
import com.example.apcrud.ui.screen.CategoryListScreen
import com.example.apcrud.ui.screen.AddCategoryScreen
import com.example.apcrud.viewmodel.AppViewModel
import com.example.apcrud.viewmodel.AppViewModelFactory
import java.lang.reflect.Modifier
import androidx.compose.fundation.layout.fillMaxSize
import com.example.apcrud.data.AppDatabase


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = AppDatabase.getDatabase(application).appDao()
        val viewModelFactory = AppViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory)[AppViewModel::class.java]

        setContent {
            ApcrudTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    CategoryListScreen(viewModel = viewModel, navController = navController)
                }
            }
        }
    }
}
