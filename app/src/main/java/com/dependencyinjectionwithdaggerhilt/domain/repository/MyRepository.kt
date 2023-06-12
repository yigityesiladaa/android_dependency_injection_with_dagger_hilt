package com.dependencyinjectionwithdaggerhilt.domain.repository

interface MyRepository {

    suspend fun doNetworkCall()

}