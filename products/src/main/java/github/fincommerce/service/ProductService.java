package github.fincommerce.service;

import github.fincommerce.entity.Product;
import github.fincommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {
    public static final String KEY = "PRODUCTS";
    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = KEY, key = "#productId", unless = "#result == null")
    public Product fetchByProductId(BigInteger productId) {
        var product = productRepository.findByProductId(productId);

        if (product == null) {
            throw new RuntimeException("Unexpected result");
        }
        return (Product) product;
    }

    @Cacheable(value = KEY, unless = "#result == null")
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

}
