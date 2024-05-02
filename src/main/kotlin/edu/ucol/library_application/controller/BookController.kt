package edu.ucol.library_application.controller

import edu.ucol.library_application.model.dto.BookDto
import edu.ucol.library_application.model.request.BookRequest
import edu.ucol.library_application.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/api/books")
@CrossOrigin("http://localhost:3000")
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping
    fun loadAllBooks(): ResponseEntity<List<BookDto>> {
        return ResponseEntity<List<BookDto>>(bookService.loadAllBooks(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun loadBooks(@PathVariable id: Long): ResponseEntity<BookDto> {
        return ResponseEntity<BookDto>(bookService.loadBookById(id), HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long): ResponseEntity<Void> {
        bookService.deleteBookById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PostMapping
    fun createBook(@RequestBody bookRequest: BookRequest): ResponseEntity<BookDto> {
        return ResponseEntity<BookDto>(
            bookService.saveBook(
              BookDto(
                  bookRequest.id,
                  bookRequest.isbn,
                  bookRequest.name,
                  bookRequest.author,
                  bookRequest.releaseDate,
                  bookRequest.editorial
              )
            ),
            HttpStatus.CREATED
        )
    }

    @PutMapping
    fun saveBook(@RequestBody bookRequest: BookRequest): ResponseEntity<BookDto> {
        return ResponseEntity<BookDto>(
            bookService.saveBook(
                BookDto(
                    bookRequest.id,
                    bookRequest.isbn,
                    bookRequest.name,
                    bookRequest.author,
                    bookRequest.releaseDate,
                    bookRequest.editorial
                )
            ),
            HttpStatus.CREATED
        )
    }
}