package org.academiadecodigo.hackathon.model.products;

import org.academiadecodigo.hackathon.model.AbstractModel;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "category")
public class Category extends AbstractModel {

    private String name;

    @OneToMany(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "category"
    )
    private Map<Integer, Product> productMap;


    public Category() {
        this.productMap = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<Integer, Product> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(Product product){
        product.setCategory(this);
        productMap.put(product.getId(), product);
    }
}

