package com.gamedeveloper.android

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.gamedeveloper.shared.LessonRepository

class LessonDetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_LESSON_ID = "extra_lesson_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val lessonId = intent.getIntExtra(EXTRA_LESSON_ID, -1)
        val lesson = LessonRepository.getLessonById(lessonId)

        val titleView: TextView = findViewById(R.id.detail_title)
        val contentView: TextView = findViewById(R.id.detail_content)

        if (lesson != null) {
            titleView.text = lesson.title
            contentView.text = lesson.content
        } else {
            titleView.text = getString(R.string.app_name)
            contentView.text = getString(R.string.lesson_not_found)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}
