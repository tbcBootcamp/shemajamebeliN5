package com.example.shemajamebelin5.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebelin5.R
import com.example.shemajamebelin5.databinding.NewCourcesItemBinding
import com.example.shemajamebelin5.models.CourseModel

class NewCoursesAdapter :
    ListAdapter<CourseModel.NewCourse, NewCoursesAdapter.NewCourseViewHolder>(ItemCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewCourseViewHolder {
        val binding =
            NewCourcesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewCourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewCourseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class NewCourseViewHolder(private val binding: NewCourcesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: CourseModel.NewCourse) {
            with(binding) {
                if (model.iconType == "settings") {
                    icIntroduce.setImageResource(R.drawable.ic_settings)
                } else {
                    icIntroduce.setImageResource(R.drawable.ic_wallet)
                }
                cl.setBackgroundColor(Color.parseColor("#${model.mainColor}"))
                tvIntroduce.text = model.title
                tvTime.text = "${model.duration} min"
                tvWhatIsIt.text = model.question
            }
        }
    }
    object ItemCallback : DiffUtil.ItemCallback<CourseModel.NewCourse>() {
        override fun areItemsTheSame(
            oldItem: CourseModel.NewCourse,
            newItem: CourseModel.NewCourse,
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: CourseModel.NewCourse,
            newItem: CourseModel.NewCourse,
        ): Boolean {
            return oldItem == newItem
        }
    }
}

