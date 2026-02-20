package com.gamedeveloper.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gamedeveloper.shared.Lesson

class LessonAdapter(
    private val lessons: List<Lesson>,
    private val onLessonClick: (Lesson) -> Unit
) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    inner class LessonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberText: TextView = itemView.findViewById(R.id.lesson_number)
        val titleText: TextView = itemView.findViewById(R.id.lesson_title)
        val summaryText: TextView = itemView.findViewById(R.id.lesson_summary)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lesson, parent, false)
        return LessonViewHolder(view)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.numberText.text = lesson.id.toString()
        holder.titleText.text = lesson.title
        holder.summaryText.text = lesson.summary
        holder.itemView.setOnClickListener { onLessonClick(lesson) }
    }

    override fun getItemCount(): Int = lessons.size
}
