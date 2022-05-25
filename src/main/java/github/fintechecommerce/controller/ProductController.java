package github.fintechecommerce.controller;

import github.fintechecommerce.entity.Product;
import github.fintechecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "${api_prefix}/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product saveDepartment(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") UUID id) {
        return productService.findProductById(id);
    }
}
