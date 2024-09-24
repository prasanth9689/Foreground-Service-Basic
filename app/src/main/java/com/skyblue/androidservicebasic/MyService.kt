package com.skyblue.androidservicebasic

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService: Service() {
    private val TAG = "MainActivity_"

    @Override
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra("inputExtra")

        Toast.makeText(this, "Service has started running in the background", Toast.LENGTH_SHORT).show()

        if (intent != null){
            Log.d(TAG, "Service Name: $input")
        }

        Log.d(TAG, "Service Status : Service has been started")

        for (i in 1..10){
            Thread.sleep(100)
            Log.d(TAG, "Service is running: $i")
        }
        stopSelf()
        return START_STICKY
    }

    override fun stopService(name: Intent?): Boolean {
        Log.d(TAG, "Service Status : Service has been stopped")
        return super.stopService(name)
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "Service execution completed", Toast.LENGTH_SHORT).show()
        Log.d(TAG,"Stopped : Service Stopped")
        super.onDestroy()
    }
}

