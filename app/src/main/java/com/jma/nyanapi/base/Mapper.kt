package com.jma.nyanapi.base

fun interface Mapper<in E, out T> {
    fun map(params: E): T
}