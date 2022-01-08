package com.gdsciitbhu.android.alarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.button).setOnClickListener {

            val title = findViewById<EditText>(R.id.title).text.toString()
            val desc = findViewById<EditText>(R.id.desc).text.toString()
            val timeInterval = findViewById<EditText>(R.id.timeInterval).text.toString().toLong()

            val inputData = Data.Builder()
                .putString("title",title)
                .putString("desc",desc)
                .build()

            val workRequest = OneTimeWorkRequestBuilder<AlarmWorker>()
                .setInputData(inputData)
                .setConstraints(Constraints.Builder().setRequiresCharging(true).build())
                .setInitialDelay(timeInterval,TimeUnit.MINUTES)
                .build()

            WorkManager.getInstance(this).enqueue(workRequest)
        }
    }
}