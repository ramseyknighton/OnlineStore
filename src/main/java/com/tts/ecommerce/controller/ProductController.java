package com.tts.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.tts.ecommerce.model.Product;
import com.tts.ecommerce.service.ProductService;
import com.tts.ecommerce.service.UserService;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/product/{id}")
    public String show(@PathVariable Long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }


}
