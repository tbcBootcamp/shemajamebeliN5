package com.example.shemajamebelin5.ui.fragments.courses

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.shemajamebelin5.adapters.ActiveCoursesAdapter
import com.example.shemajamebelin5.adapters.NewCoursesAdapter
import com.example.shemajamebelin5.base.BaseFragment
import com.example.shemajamebelin5.databinding.FragmentCourcesBinding
import com.example.shemajamebelin5.network.NetworkModule
import com.example.shemajamebelin5.repository.CoursesRepository
import kotlinx.coroutines.launch

class CoursesFragment : BaseFragment<FragmentCourcesBinding>(FragmentCourcesBinding::inflate) {

    private val viewModel: CoursesViewModel by viewModels {
        CoursesViewModelFactory(CoursesRepository(NetworkModule.createApiService()))
    }

    private lateinit var newCoursesAdapter: NewCoursesAdapter
    private lateinit var activeCoursesAdapter: ActiveCoursesAdapter

    override fun setUp() {
        newCoursesAdapter = NewCoursesAdapter()
        binding.rvNewCourses.adapter = newCoursesAdapter


        activeCoursesAdapter = ActiveCoursesAdapter()
        binding.rvActiveCourses.adapter = activeCoursesAdapter



    }


    override fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.courses.collect { state ->
                    when (state) {
                        is CoursesViewModel.CoursesViewState.Loading -> {
                            // Handle loading UI state, e.g., show/hide progress bar
                      //      binding.loader.isVisible = true
                        }
                        is CoursesViewModel.CoursesViewState.Success -> {
                            // Handle success state
                            newCoursesAdapter.submitList(state.newCourses)
                            activeCoursesAdapter.submitList(state.activeCourses)
                            //binding.loader.isVisible = false
                        }
                        is CoursesViewModel.CoursesViewState.Error -> {
                            // Handle error state, e.g., show an error message
                         //   binding.loader.isVisible = false
                            Toast.makeText(requireContext(), state.errorMessage, Toast.LENGTH_SHORT).show()
                        }

                        else -> {}
                    }
                }
            }
        }
    }
}