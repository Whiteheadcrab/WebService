package whiteheadcrab.springframework.Exceptions;

public class BookNotFoundException extends Exception
{
    private long bookId;

    public BookNotFoundException(long bookId)
    {
        super(String.format("Book with id '%s' was not able to find",bookId));
    }
}
