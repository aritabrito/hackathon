package org.academiadecodigo.hackathon.service;

import org.academiadecodigo.hackathon.model.AbstractModel;

import java.util.List;

public interface CRUDService<T extends AbstractModel> extends Service {


    List<T> list();

    T get(Integer id);

    T save(T modelObject);

    void delete(Integer id);


}
