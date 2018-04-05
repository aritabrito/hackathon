package org.academiadecodigo.hackathon.persistence;

public class TransactionExcepiton extends RuntimeException{

    public TransactionExcepiton(Throwable cause) {
        super(cause);
    }
}
