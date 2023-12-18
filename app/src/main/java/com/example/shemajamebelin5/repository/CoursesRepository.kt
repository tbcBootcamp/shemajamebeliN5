package com.example.shemajamebelin5.repository

import com.example.shemajamebelin5.models.CourseModel
import com.example.shemajamebelin5.network.ApiService

class CoursesRepository(private val apiService: ApiService) {

    suspend fun getCourses(): CourseModel {
        return apiService.getCourses()
    }
}