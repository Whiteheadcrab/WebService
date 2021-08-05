package whiteheadcrab.springframework.Model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String bookName;

    @NotNull
    private String authorName;

    @NotNull
    private String isbn;

    public Book(Long id, String bookName, String authorName, String isbn)
    {
        this.id = id;
        this.bookName = bookName;
        this.authorName = authorName;
        this.isbn = isbn;
    }

    public Book()
    {
        super();
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getBookName()
    {
        return bookName;
    }

    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }
}
