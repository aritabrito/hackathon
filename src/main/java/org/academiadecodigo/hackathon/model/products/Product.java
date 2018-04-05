package org.academiadecodigo.hackathon.model.products;

import org.academiadecodigo.hackathon.model.AbstractModel;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product extends AbstractModel {

    @ManyToOne
    private Category category;

    private String name;

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }

}
