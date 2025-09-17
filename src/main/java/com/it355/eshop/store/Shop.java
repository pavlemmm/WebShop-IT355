package com.it355.eshop.store;

import com.it355.eshop.model.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Component
@ApplicationScope
public class Shop {
    private final Map<Long, Product> products = new HashMap<>();
    private final Map<Long, Category> categories = new HashMap<>();
    private final AtomicLong productSeq = new AtomicLong(1);
    private final AtomicLong categorySeq = new AtomicLong(1);

    public Shop() {
        Category c1 = addCategory("Laptops");
        Category c2 = addCategory("Accessories");
        addProduct(new Product(null, "Lenovo IdeaPad", 699));
        addProduct(new Product(null, "Logitech Mouse", 25));
    }

    public List<Product> allProducts() { return new ArrayList<>(products.values()); }
    public Product addProduct(Product p) {
        p.setId(productSeq.getAndIncrement());
        products.put(p.getId(), p);
        return p;
    }
    public void updateProduct(Product p) { products.put(p.getId(), p); }
    public void deleteProduct(Long id) { products.remove(id); }
    public Product findProduct(Long id) { return products.get(id); }

    public List<Category> allCategories() { return new ArrayList<>(categories.values()); }
    public Category addCategory(String name) {
        Category c = new Category(categorySeq.getAndIncrement(), name);
        categories.put(c.getId(), c);
        return c;
    }
}
