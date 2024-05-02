package edu.ucol.library_application

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryApplication

fun main(args: Array<String>) {
	runApplication<LibraryApplication>(*args)
}
