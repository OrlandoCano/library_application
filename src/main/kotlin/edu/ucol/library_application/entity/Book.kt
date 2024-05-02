package edu.ucol.library_application.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.*

@Entity
@Table(name = "BOOK")
data class Book(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val ISBN: String,
    val name: String,
    val author: String,
    val releaseDate: Date,
    val editorial: String
) {
}