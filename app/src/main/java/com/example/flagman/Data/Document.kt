package com.example.flagman.Data
import kotlinx.serialization.*

@Serializable
data class Document(
    val id: Long,
    val title: String,
    val company: Company,
    val createdAt: String,
    val recipientsCount: Long,
    val signingStatus: String,
    val documentUrl: String,
)

data class Company(
    val id: Long,
    val name: String,
)