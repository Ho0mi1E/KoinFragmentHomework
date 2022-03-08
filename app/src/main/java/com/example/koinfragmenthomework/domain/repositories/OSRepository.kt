package com.example.koinfragmenthomework.domain.repositories

import com.example.koinfragmenthomework.domain.models.OS

interface OSRepository {
    fun getOS(): List<OS>
}