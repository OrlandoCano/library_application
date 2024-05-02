package edu.ucol.library_application.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class LibraryApplicationExceptionHandler {
    @ExceptionHandler(value = [BookNotFoundException::class])
    fun handleBookNotFound(exception: RuntimeException): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(exception.message)
    }
}
