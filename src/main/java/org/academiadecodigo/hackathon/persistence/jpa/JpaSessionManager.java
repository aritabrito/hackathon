package org.academiadecodigo.hackathon.persistence.jpa;

import org.academiadecodigo.hackathon.model.Model;
import org.academiadecodigo.hackathon.persistence.SessionManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaSessionManager implements SessionManager<EntityManager> {


    EntityManager em;
    EntityManagerFactory emf;

    public JpaSessionManager() {
        emf = Persistence.createEntityManagerFactory("simone");
    }

    @Override
    public void startSession() {
        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    @Override
    public void stopSession() {
        if (em != null) {
            em.close();
        }
        em = null;
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

}
