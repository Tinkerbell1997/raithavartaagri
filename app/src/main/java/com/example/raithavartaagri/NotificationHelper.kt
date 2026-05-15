package com.example.raithavarta

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificationHelper(
    private val context: Context
) {

    companion object {
        const val CHANNEL_ID = "tip_channel"
    }

    fun showNotification() {

        val manager = context.getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                CHANNEL_ID,
                "Daily Tips",
                NotificationManager.IMPORTANCE_HIGH
            )

            manager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(
            context,
            CHANNEL_ID
        )
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("Raitha-Varta")
            .setContentText(
                "Your tip for today is ready 🌱"
            )
            .setPriority(
                NotificationCompat.PRIORITY_HIGH
            )

        manager.notify(1, builder.build())
    }
}