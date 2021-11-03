package com.kkhura.api

import com.kkhura.call.ServiceCall


interface APIResolver {
    fun <T> resolve(paramString: String, paramMap: Map<*, *>): ServiceCall<T>
}