package com.example.librarysystem;

import com.example.librarysystem.model.Book;
import com.example.librarysystem.repository.BookRepository;
import com.example.librarysystem.service.BookService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SimpleMockitoTest {

    @Mock //The object below this will be a fake object 
    private BookRepository bookRepository;

    @InjectMocks 
    private BookService bookService;

    @Test
    void testAddBook() {
        // Arrange - Setup test data
        Book book = new Book("JFS", "P Reddy");
        when(bookRepository.save(any(Book.class))).thenReturn(book);

        // Act - Call the method we want to test
        Book result = bookService.addBook(book);

        // Assert - Check the results
        assertEquals("JFS", result.getTitle());
        verify(bookRepository).save(book);
    }

    @Test
    void testAddTwoNumbers() {
        // Arrange - Setup test data to check the testing 
        int n1 = 5;
        int n2 = 3;
        int expected = 8;

        // Act - Performing addition on two values 
        int result = n1 + n2;

        // Assert - Check the result
        assertEquals(expected, result); // it is a function taken from java 
        //if both are equal it will pass else it will fail     
    }
}