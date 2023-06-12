package com.dependencyinjectionwithdaggerhilt

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.dependencyinjectionwithdaggerhilt.domain.repository.MyRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyService : Service() {

    @Inject
    lateinit var repository: MyRepository

    override fun onCreate() {
        super.onCreate()
        repository
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }
}