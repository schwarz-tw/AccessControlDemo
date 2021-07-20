package com.example.demo.domain.exception;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(long cardId) {
        super("Card with id: " + cardId + " not found");
    }
}
