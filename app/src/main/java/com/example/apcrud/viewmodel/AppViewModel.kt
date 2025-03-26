package com.example.apcrud.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import com.example.apcrud.data.AppDao
import com.example.apcrud.model.Category
import com.example.apcrud.model.Item

class AppViewModel(private val dao: AppDao) : ViewModel() {
    val categories: Flow<List<Category>> = dao.getCategories()

    fun getItemsByCategory(categoryId: Int): Flow<List<Item>> {
        return dao.getItemsByCategory(categoryId)
    }

    fun insertCategory(category: Category) {
        viewModelScope.launch { dao.insertCategory(category) }
    }

    fun insertItem(item: Item) {
        viewModelScope.launch { dao.insertItem(item) }
    }

    fun deleteCategory(category: Category) {
        viewModelScope.launch { dao.deleteCategory(category) }
    }

    fun deleteItem(item: Item) {
        viewModelScope.launch { dao.deleteItem(item) }
    }
}
