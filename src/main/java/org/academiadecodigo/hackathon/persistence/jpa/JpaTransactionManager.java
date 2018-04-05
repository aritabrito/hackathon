package org.academiadecodigo.hackathon.persistence.jpa;

import org.academiadecodigo.hackathon.persistence.SessionManager;
import org.academiadecodigo.hackathon.persistence.TransactionManager;

import javax.persistence.EntityManager;

public class JpaTransactionManager implements TransactionManager {

    SessionManager<EntityManager> sm;

    public JpaTransactionManager(SessionManager sm) {
        this.sm = sm;
    }

    @Override
    public void beginRead() {
        sm.startSession();
    }

    @Override
    public void beginWrite() {
        sm.getEntityManager().getTransaction().begin();
    }

    @Override
    public void commit() {
        if (sm.getEntityManager().getTransaction().isActive()){
            sm.getEntityManager().getTransaction().commit();
        }
    }

    @Override
    public void rollback() {
        if (sm.getEntityManager().getTransaction().isActive()){
            sm.getEntityManager().getTransaction().rollback();
        }

    }
}
