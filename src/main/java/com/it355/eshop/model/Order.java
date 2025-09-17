package com.it355.eshop.model;

import java.util.List;

public class Order {
    private Long id;
    private Long userId;
    private List<CartItem> items;
    private String status;

    public Order() {}
    public Order(Long id, Long userId, List<CartItem> items, String status) {
        this.id = id; this.userId = userId; this.items = items; this.status = status;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
