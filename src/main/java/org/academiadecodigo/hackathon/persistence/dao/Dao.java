package org.academiadecodigo.hackathon.persistence.dao;

import org.academiadecodigo.hackathon.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    /**
     *
     * Retrieves the data from the database by id
     *
     */

    T findById(Integer id);

    /**
     *
     * Saves or updates the data in the database
     *
     */

    T saveOrUpdate(T model);

    /**
     *
     * Returns a list of models
     *
     */

    List<T> findAll();

    /**
     *
     * deletes the model
     */

    void delete(Integer id);


}
