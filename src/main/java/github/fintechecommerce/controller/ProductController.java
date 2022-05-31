package github.fintechecommerce.controller;

import github.fintechecommerce.entity.Product;
import github.fintechecommerce.model.ResponseModel;
import github.fintechecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
<<<<<<< HEAD
        return new ResponseModel<>(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(), productService.findAllProducts());
=======
        return new ResponseModel<>(productService.fetchAllProducts());
>>>>>>> b5bd8728b912075308779c9a78675d088e96d7f3
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Product> getProduct(@PathVariable("id") BigInteger productId) {
        return new ResponseModel<>(productService.fetchByProductId(productId));
    }
}
