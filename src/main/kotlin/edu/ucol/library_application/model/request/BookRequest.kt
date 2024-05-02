package edu.ucol.library_application.model.request

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.Date

@JsonIgnoreProperties(ignoreUnknown = true)
data class BookRequest(
    val id: Long,
    val isbn: String,
    val name: String,
    val author: String,
    val releaseDate: Date,
    val editorial: String
)
