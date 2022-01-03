package com.gdsciitbhu.android.alarm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val time = 1L
        val title = "Hello World"
        val description = "It's morning already"
        val workManager = WorkManager.getInstance(this)
        workManager.enqueue(
            OneTimeWorkRequestBuilder<AlarmWorker>()
                .setInitialDelay(time, TimeUnit.MINUTES)
                .setInputData(workDataOf("title" to title, "description" to description))
                .build()
        )

    }
}