package github.fincommerce.controller;

import github.fincommerce.entity.Product;
import github.fincommerce.model.ResponseModel;
import github.fincommerce.service.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "${api_prefix}/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping({"", "/"})
    public ResponseModel<List<Product>> getProducts() {
        return new ResponseModel<>(productService.fetchAllProducts());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Product> getProduct(@NonNull @PathVariable("id") BigInteger productId) {
        return new ResponseModel<>(productService.fetchByProductId(productId));
    }
}
