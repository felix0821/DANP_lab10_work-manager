package com.plcoding.workmanagerguide

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log.d
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters

class BackgroundTask (context : Context, params : WorkerParameters)
    : Worker(context, params){

    override fun doWork(): Result {

        d("oneTimeWorkRequest","Subiendo fotos en segundo plano")
        sendNotification("Tarea de fondo","Hecho exitosamente")
        return Result.success()
    }

    private fun sendNotification(title: String, message: String) {
        val notificationManager =
            applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        //If on Oreo then notification required a notification channel.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel =
                NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(channel)
        }
        val notification: NotificationCompat.Builder = NotificationCompat.Builder(
            applicationContext,
            "default"
        )
            .setContentTitle(title)
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
        notificationManager.notify(1, notification.build())
    }

}