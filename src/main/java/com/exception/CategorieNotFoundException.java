package com.exception;
import com.model.Categorie;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategorieNotFoundException extends RuntimeException{
    public CategorieNotFoundException(String message) {
        super(message);
    }
}
