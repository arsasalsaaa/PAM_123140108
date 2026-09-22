package com.example.p2_123140108

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform