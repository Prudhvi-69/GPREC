package com.example.librarysystem.service;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.repository.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;
//DI : Obj handled by Spring, you stay Idle

//    BookRepository object = new BookRepository();
//Obj handled by You, Spring stays Idle



    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book existing = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        return bookRepository.save(existing);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(()   -> new RuntimeException("Book not found"));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
