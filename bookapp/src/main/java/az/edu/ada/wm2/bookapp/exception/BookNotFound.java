package az.edu.ada.wm2.bookapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFound extends RuntimeException {
    public BookNotFound() {
        super("Book not found");
    }
}
