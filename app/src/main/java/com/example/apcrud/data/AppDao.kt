package com.example.apcrud.data
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import com.example.apcrud.model.Category
import com.example.apcrud.model.Item

@Dao
interface AppDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item): Long

    @Query("SELECT * FROM category_table")
    fun getAllCategories(): Flow<List<Category>>

    @Query("SELECT * FROM item_table WHERE categoryId = :categoryId")
    fun getItemsByCategory(categoryId: Int): Flow<List<Item>>
}
