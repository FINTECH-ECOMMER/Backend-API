package github.fintechecommerce.service;

import github.fintechecommerce.entity.Product;
import github.fintechecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {
    public static final String KEY = "PRODUCTS";
    @Autowired
    private ProductRepository productRepository;

    //    @Cacheable(value = KEY, key = "#productId", unless = "#result == null")
    public Product fetchByProductId(BigInteger productId) {
        return productRepository.findByProductId(productId);
    }

    //    @Cacheable(value = KEY, unless = "#result == null")
    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }

}
