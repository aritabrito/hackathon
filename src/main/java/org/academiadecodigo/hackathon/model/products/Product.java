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

    private Integer price;

    private String description;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
