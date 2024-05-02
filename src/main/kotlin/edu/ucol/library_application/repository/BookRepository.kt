package edu.ucol.library_application.repository

import edu.ucol.library_application.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long>