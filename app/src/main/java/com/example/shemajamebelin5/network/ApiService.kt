package com.example.shemajamebelin5.network

import com.example.shemajamebelin5.models.CourseModel
import retrofit2.http.GET

interface ApiService {
    @GET("v3/83160a49-fe85-46ba-bcf8-3cf5aa09f92b")
    suspend fun getCourses(): CourseModel
}