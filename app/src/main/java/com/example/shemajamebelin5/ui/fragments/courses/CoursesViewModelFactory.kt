package com.example.shemajamebelin5.ui.fragments.courses

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shemajamebelin5.repository.CoursesRepository

class CoursesViewModelFactory(private val repository: CoursesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CoursesViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CoursesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}