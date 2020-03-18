package co.com.todo1.hulkstore.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NoProductsInStockException extends RuntimeException {

    public NoProductsInStockException(String message) {
        super(message);
    }
}
