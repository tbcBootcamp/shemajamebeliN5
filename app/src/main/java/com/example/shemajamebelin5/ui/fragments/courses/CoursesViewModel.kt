package com.example.shemajamebelin5.ui.fragments.courses

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shemajamebelin5.models.CourseModel
import com.example.shemajamebelin5.repository.CoursesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class CoursesViewModel(private val repository: CoursesRepository) : ViewModel() {

    private val _courses = MutableStateFlow<CoursesViewState>(CoursesViewState.Loading)
    val courses = _courses.asStateFlow()

    init {
        fetchCourses()
    }

    private fun fetchCourses() {
        viewModelScope.launch {
            try {
                val coursesResponse = repository.getCourses()
                val newCourses = coursesResponse.new_courses.orEmpty()
                val activeCourses = coursesResponse.active_courses.orEmpty()
                _courses.value = CoursesViewState.Success(newCourses, activeCourses)
                Log.d("jumberi",coursesResponse.toString())
            } catch (e: Exception) {
                _courses.value = CoursesViewState.Error("Failed to fetch courses")
                e.printStackTrace()
            }
        }
    }
    sealed class CoursesViewState {
        object Loading : CoursesViewState()
        data class Success(
            val newCourses: List<CourseModel.NewCourse>,
            val activeCourses: List<CourseModel.ActiveCourses>
        ) : CoursesViewState()

        data class Error(val errorMessage: String) : CoursesViewState()
    }


}

/*sealed class CoursesViewState {
    object Loading : CoursesViewState()
    data class Success(
        val newCourses: List<CourseModel.NewCourse>,
        val activeCourses: List<CourseModel.ActiveCourses>
    ) : CoursesViewState()

    data class Error(val errorMessage: String) : CoursesViewState()
}*/


