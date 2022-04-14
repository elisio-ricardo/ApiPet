package com.gft.ApiPet.exception;

public class EntityNotFoundException extends PetException {


    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String message) {
        super(message);
    }
}
