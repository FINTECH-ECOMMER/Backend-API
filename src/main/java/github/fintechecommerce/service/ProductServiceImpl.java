package github.fintechecommerce.service;

import github.fintechecommerce.entity.Product;
import github.fintechecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    @Cacheable(key = "#productId",value = "Product")
    public Product fetchByProductId(BigInteger productId) {
        return productRepository.fetchByProductId(productId);
    }

    @Override
    public List<Product> fetchAllProducts() {
        return productRepository.fetchAllProducts();
    }
}
