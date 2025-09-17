package com.it355.eshop.web;

import com.it355.eshop.store.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final Shop shop;

    public HomeController(Shop shop) {
        this.shop = shop;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("products", shop.allProducts());
        return "index";
    }
}
