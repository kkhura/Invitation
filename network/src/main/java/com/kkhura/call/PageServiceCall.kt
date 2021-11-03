package com.kkhura.call


interface PageServiceCall<T>: ServiceCall<T> {
    fun getPageNumber(): Int
}