package com.kkhura.call

import java.lang.reflect.Type

interface ServiceCall<T> : Call<T> {
    fun getIdentifier():String
    fun getModuleName():String
    fun getShouldCache():Boolean
    fun getType(): Type
}