package io.github.kabirnayeem99.darulifta

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import src.core.di.initKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
        }
    }
}