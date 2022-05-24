package github.fintechecommerce.controller;

import github.fintechecommerce.model.GeneralResponse;
import github.fintechecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping(path = "${api_prefix}/products")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping({"", "/"})
    public GeneralResponse getProducts() {
        return new GeneralResponse(productService.findAllProducts());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public GeneralResponse getProduct(@PathVariable("id") BigInteger productId) {

        return new GeneralResponse(productService.findProductById(productId));
    }
}
