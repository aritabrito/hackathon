package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.model.Model;
import org.academiadecodigo.hackathon.persistence.dao.Dao;

public abstract class JpaAbstractDao<T extends Model> implements Dao<T> {
}
