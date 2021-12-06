package com.leanderoid.adventofdroid

import android.app.Application

class AdventApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectGraph.provide(this)
    }
}