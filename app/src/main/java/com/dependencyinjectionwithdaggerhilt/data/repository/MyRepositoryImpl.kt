package com.dependencyinjectionwithdaggerhilt.data.repository

import android.app.Application
import com.dependencyinjectionwithdaggerhilt.R
import com.dependencyinjectionwithdaggerhilt.data.remote.MyApi
import com.dependencyinjectionwithdaggerhilt.domain.repository.MyRepository
import javax.inject.Inject

class MyRepositoryImp @Inject constructor(
    private val api : MyApi,
    private val appContext : Application,
    ) : MyRepository {

    init {
        val appName = appContext.getString(R.string.app_name)
        println("Hello from the repository. The App Name is $appName")
    }

    override suspend fun doNetworkCall() {

    }
}