package com.example.shemajamebelin5.models

import com.squareup.moshi.Json

data class CourseModel(
    val active_courses: List<ActiveCourses>?,
    val new_courses: List<NewCourse>?,
) {
    data class NewCourse(
        val duration: String?,
        @Json(name = "icon_type")
        val iconType: String?,
        val id: String?,
        @Json(name = "main_color")
        val mainColor: String?,
        val question: String?,
        val title: String?,
    )

    data class ActiveCourses(
        @Json(name = "background_color_present")
        val backgroundColorPercent: Int?,
        @Json(name = "booking_time")
        val bookingTime: String?,
        val id: String?,
        val image: String?,
        @Json(name = "main_color")
        val mainColor: String?,
        @Json(name = "play_button_color_percent")
        val playButtonColorPercent: String?,
        val progress: Int,
        val title: String?,
    )
}