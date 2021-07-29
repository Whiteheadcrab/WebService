package whiteheadcrab.springframework.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import whiteheadcrab.springframework.Exceptions.BookNotFoundException;
import whiteheadcrab.springframework.Model.Book;
import whiteheadcrab.springframework.Repositories.BookRepository;


import java.util.List;

@RestController
public class BookController
{
    @Autowired
    BookRepository bookRepository;

    //Search * books
    @GetMapping("/books")
    public List getAllNotes()
    {
        return bookRepository.findAll();
    }

    //Create new object book
    @PostMapping("/books")
    public Book createNewBook(@Validated @RequestBody Book book)
    {
       return (Book) bookRepository.save(book);
    }

    //Find book by id
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable(value = "id") Long id) throws Throwable
    {
        return (Book) bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @PutMapping("/books/{id}")
    public Book updateBookNote(@PathVariable(value = "id") Long id,
                               @Validated @RequestBody Book bookData) throws Throwable
    {
        Book book = (Book) bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setBookName(bookData.getBookName());
        book.setAuthorName(bookData.getAuthorName());
        book.setIsbn(bookData.getIsbn());

        Book updatedBookSet = (Book) bookRepository.save(book);
        return updatedBookSet;
    }

    //Find book by id and delete it
    @DeleteMapping("/books/{id}")
    public ResponseEntity deleteBookById(@PathVariable(value = "id")  Long id) throws Throwable
    {
        Book book = (Book) bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        bookRepository.delete(book);
        return ResponseEntity.ok().build();
    }

}
