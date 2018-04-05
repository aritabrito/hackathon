package org.academiadecodigo.hackathon.persistence;

public interface TransactionManager {


    /**
     * Initializes reading
     */
    void beginRead();


    /**
     * starts the transaction
     */
    void beginWrite();


    /**
     * Commits the transaction
     */
    void commit();


    /**
     * rollback the transaction
     */
    void rollback();


}
