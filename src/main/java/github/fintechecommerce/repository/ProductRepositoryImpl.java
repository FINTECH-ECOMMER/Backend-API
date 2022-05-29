package github.fintechecommerce.repository;

import github.fintechecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String KEY = "PRODUCT";

    @Override
    public Product findByProductId(BigInteger productId) {
        Product product;
        product = (Product) redisTemplate.opsForHash().get(KEY, productId.toString());
        return product;
    }

    @Override
    public List<Product> findAllProducts() {
        List<Product> products;
        products = redisTemplate.opsForHash().values(KEY);
        return products;
    }

}
