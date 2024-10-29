package com.virtualstudios.cmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform