package github.fintechecommerce.service;

import github.fintechecommerce.entity.Product;

import java.math.BigInteger;
import java.util.List;

public interface ProductService {
    Product fetchByProductId(BigInteger productId);
    List<Product> fetchAllProducts();
}
