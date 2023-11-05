package com.example.myanimelist.view

import android.app.Application
import com.example.myanimelist.data.repositories.RepositoriesLocator

class AnimeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RepositoriesLocator.setContext(applicationContext)
    }

}