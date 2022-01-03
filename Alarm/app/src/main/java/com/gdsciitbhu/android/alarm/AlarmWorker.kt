package com.gdsciitbhu.android.alarm

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

class AlarmWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {

    override fun doWork(): Result {
        val title = inputData.getString("title") ?: ""
        val description = inputData.getString("description") ?: ""
        showNotification(title, description)
        return Result.success()
    }

    private fun showNotification(title: String, description: String) {
        val context = applicationContext
        val notificationManager = NotificationManagerCompat.from(context)
        val channelId = "alarm_channel"
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel(channelId, "Alarm Channel", NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
        val notification = NotificationCompat.Builder(context, channelId)
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(R.mipmap.ic_launcher)
            .build()
        notificationManager.notify(Random.nextInt(), notification)
    }
}