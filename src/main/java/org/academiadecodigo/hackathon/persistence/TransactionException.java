package org.academiadecodigo.hackathon.persistence;

public class TransactionException extends RuntimeException{

    public TransactionException(Throwable cause) {
        super(cause);
    }
}
