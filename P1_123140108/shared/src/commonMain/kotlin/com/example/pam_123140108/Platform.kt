package com.example.pam_123140108

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform