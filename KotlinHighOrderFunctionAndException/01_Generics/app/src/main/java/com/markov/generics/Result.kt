package com.markov.generics

sealed class Result<out T, R> {

    data class Success<T, R>(val item: T) : Result<T, R>()

    data class Error<T, R>(val item: R) : Result<T, R>() {
        override fun getResult(): Result<Int, String> {
            return Result(false, item)
        }
    }

    abstract fun getResult(): Result<Int, String>

}
