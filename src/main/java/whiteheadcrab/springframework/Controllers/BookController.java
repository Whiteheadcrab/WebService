package whiteheadcrab.springframework.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import whiteheadcrab.springframework.Model.Books;
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
    public Books createNewBook(@Validated @RequestBody Books book)
    {
       return bookRepository.save(book);
    }

    @GetMapping("/book/{id}")
    public Books getBookById(@PathVariable(value = "id")
                             Long id, @Validated @RequestBody Books bookData,) throws BooksNotFoundException
    {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BooksNotFoundException(id));
    }

}
