package com.example.levanhomework7

import android.app.Application
import com.example.levanhomework7.api.RetrofitClient

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        RetrofitClient.initClient()
    }
}

