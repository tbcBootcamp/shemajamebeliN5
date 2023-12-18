package com.example.shemajamebelin5.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebelin5.databinding.ActiveCourcesItemBinding
import com.example.shemajamebelin5.models.CourseModel
import com.example.shemajamebelin5.utils.setImage

class ActiveCoursesAdapter :
    ListAdapter<CourseModel.ActiveCourses, ActiveCoursesAdapter.ActiveCourseViewHolder>(ItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActiveCourseViewHolder {
        val binding =
            ActiveCourcesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ActiveCourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ActiveCourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ActiveCourseViewHolder(private val binding: ActiveCourcesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: CourseModel.ActiveCourses) {
            with(binding) {
                val color = Color.parseColor("#${model.mainColor}")
                tvTitle.text = model.title
                tvTitle.setTextColor(color)
                model.image?.let { ivIcon.setImage(it) }
                ivIcon.setBackgroundColor(color)
                clIcon.setBackgroundColor(color)
                tvSubText.text = model.bookingTime
                tvSubText.setTextColor(color)
                cl.setBackgroundColor(color)
                model.backgroundColorPercent?.let {
                    cl.background.alpha = it
                }
                ivStart.setColorFilter(color)
                progress.progress = model.progress
                progress.setIndicatorColor(color)
            }
        }
    }

    object ItemCallback : DiffUtil.ItemCallback<CourseModel.ActiveCourses>() {
        override fun areItemsTheSame(
            oldItem: CourseModel.ActiveCourses,
            newItem: CourseModel.ActiveCourses,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CourseModel.ActiveCourses,
            newItem: CourseModel.ActiveCourses,
        ): Boolean {
            return oldItem == newItem
        }
    }
}