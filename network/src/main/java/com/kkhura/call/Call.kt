package com.kkhura.call

import java.util.*


public interface Call<T> {
    fun execute(): Observable
}