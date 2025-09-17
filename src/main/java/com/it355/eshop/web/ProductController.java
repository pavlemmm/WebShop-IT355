package com.it355.eshop.web;

import com.it355.eshop.model.Product;
import com.it355.eshop.store.Shop;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final Shop shop;

    // ručni konstruktor umesto @RequiredArgsConstructor
    public ProductController(Shop shop) {
        this.shop = shop;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("products", shop.allProducts());
        return "product/list";
    }

    @GetMapping("/new")
    public String form(Model model) {
        model.addAttribute("product", new Product());
        return "product/form";
    }

    @PostMapping
    public String save(@ModelAttribute Product p) {
        if (p.getId() == null) {
            shop.addProduct(p);
        } else {
            shop.updateProduct(p);
        }
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", shop.findProduct(id));
        return "product/form";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        shop.deleteProduct(id);
        return "redirect:/products";
    }
}
