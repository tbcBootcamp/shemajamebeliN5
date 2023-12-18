package com.example.shemajamebelin5.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


object NetworkModule {
    private const val BASE_URL = "https://run.mocky.io/"

    fun createApiService(): ApiService {
        val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }
}

//object RetrofitClient {
//
//    private const val BASE_URL = "https://run.mocky.io/"
//    private val moshi = Moshi.Builder()
//        .addLast(KotlinJsonAdapterFactory())
//        .build()
//
//    private val retrofitBuilder by lazy {
//        Retrofit
//            .Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(moshi))
//            .build()
//    }
//    val authService: AuthService = retrofitBuilder.create(AuthService::class.java)
//}