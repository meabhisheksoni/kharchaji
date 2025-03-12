package com.example.kharchaji

import kotlinx.coroutines.flow.Flow

class TodoRepository(private val todoDao: TodoDao) {
    val allItems: Flow<List<TodoItem>> = todoDao.getAllItems()

    suspend fun insert(item: TodoItem) {
        todoDao.insert(item)
    }

    suspend fun delete(item: TodoItem) {
        todoDao.delete(item)
    }
}