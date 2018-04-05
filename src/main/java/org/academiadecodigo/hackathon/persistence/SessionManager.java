package org.academiadecodigo.hackathon.persistence;

public interface SessionManager <T> {

    /**
     * Creates a new Entity Manager
     */
    void startSession();

    /**
     * Closes connection to the database
     */
    void stopSession();

    /**
     * returns Entity Manager
     * @return
     */
    T getEntityManager();

}
