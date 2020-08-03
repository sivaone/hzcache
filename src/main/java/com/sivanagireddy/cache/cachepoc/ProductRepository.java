package com.sivanagireddy.cache.cachepoc;

import com.hazelcast.config.Config;
import com.hazelcast.config.GroupConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();

    @CachePut(value = "products", key = "#product.id")
    public Product save(Product product) {
        getProducts().put(product.getId(), product);
        return product;
    }

    @Cacheable(value = "products", key = "#id")
    public Product getById(Long id) {
        return getProducts().get(id);
    }

    public Collection<Product> getAll(){
        return getProducts().values();
    }

    public Map<Long, Product> getProducts() {
        System.out.println("Getting products");
        return products;
    }

    public void config() {
        Config hz = new Config();
        hz.setGroupConfig(new GroupConfig());
    }
}
