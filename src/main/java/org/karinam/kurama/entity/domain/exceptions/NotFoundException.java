package org.karinam.kurama.entity.domain.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String type, Long id) {
        super(String.format("%s with ID=%s not found.", type, id));
    }
}
