package github.fintechecommerce.service;

import github.fintechecommerce.entity.Product;
import github.fintechecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "Product", key = "#productId")
    public Product fetchByProductId(BigInteger productId) {
        return productRepository.findByProductId(productId);
    }

    public List<Product> fetchAllProducts() {
        return productRepository.findAll();
    }


}
