package edu.ucol.library_application.model.dto

import java.util.Date

data class BookDto(
    val id: Long?,
    val isbn: String,
    val name: String,
    val author: String,
    val releaseDate: Date?,
    val editorial: String
) {
}