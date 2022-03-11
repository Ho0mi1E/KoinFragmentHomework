package com.example.koinfragmenthomework.presintation.bonding

import com.example.koinfragmenthomework.domain.models.forView.CommonClass

interface Bonding<E: CommonClass> {
    fun bonding(item: E)
}