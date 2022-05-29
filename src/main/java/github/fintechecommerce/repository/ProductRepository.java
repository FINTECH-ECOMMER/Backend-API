package github.fintechecommerce.repository;

import github.fintechecommerce.entity.Product;

import java.math.BigInteger;
import java.util.List;

public interface ProductRepository {

    Product fetchByProductId(BigInteger productId);
    List<Product> fetchAllProducts();
}
