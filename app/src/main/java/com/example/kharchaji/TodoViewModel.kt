package com.example.kharchaji

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TodoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: TodoRepository
    val allItems: Flow<List<TodoItem>>

    init {
        val todoDao = AppDatabase.getDatabase(application).todoDao()
        repository = TodoRepository(todoDao)
        allItems = repository.allItems
    }

    fun addItem(item: TodoItem) {
        viewModelScope.launch {
            repository.insert(item)
        }
    }

    fun deleteItem(item: TodoItem) {
        viewModelScope.launch {
            repository.delete(item)
        }
    }
}