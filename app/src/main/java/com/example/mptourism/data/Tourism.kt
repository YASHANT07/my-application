package com.example.mptourism.data

import java.io.Serializable

data class Tourism(
    val id: Int,
    val title: String,
    val  description: String,
    val tourismImageId: Int = 0


): Serializable