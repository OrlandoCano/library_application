package edu.ucol.library_application.service

import edu.ucol.library_application.entity.Book
import edu.ucol.library_application.exception.BookNotFoundException
import edu.ucol.library_application.model.dto.BookDto
import edu.ucol.library_application.repository.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

interface BookService{
    fun saveBook(book: BookDto) : BookDto
    fun loadAllBooks() : List<BookDto>
    fun loadBookById (id : Long) : BookDto
    fun deleteBookById (id : Long)
}

@Service
class BookServiceImpl : BookService {

    @Autowired
    lateinit var repository: BookRepository

    override fun saveBook(book: BookDto): BookDto {
        val savedBook =
            repository.save(
                Book(
                    book.id,
                    book.isbn,
                    book.name,
                    book.author,
                    book.releaseDate ?: Date(),
                    book.editorial
                )
            )
        return BookDto(
            savedBook.id,
            savedBook.ISBN,
            savedBook.name,
            savedBook.author,
            savedBook.releaseDate,
            savedBook.editorial
        )
    }

    override fun loadAllBooks(): List<BookDto> {

        return repository.findAll().stream()
            .map { book ->
                BookDto(
                    book.id,
                    book.ISBN,
                    book.name,
                    book.author,
                    book.releaseDate,
                    book.editorial
                )
            }
            .collect(Collectors.toList())
    }

    override fun loadBookById(id: Long): BookDto {
        val book =
            repository
                .findById(id)
                .orElseThrow { BookNotFoundException(String.format("Book with id=%s not found", id)) }

        return BookDto(
            book.id,
            book.ISBN,
            book.name,
            book.author,
            book.releaseDate,
            book.editorial
        )
    }

    override fun deleteBookById(id: Long) {
        return repository.deleteById(id)
    }
}
