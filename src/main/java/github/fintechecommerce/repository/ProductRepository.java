package github.fintechecommerce.repository;

import github.fintechecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ProductRepository extends JpaRepository<Product, BigInteger> {

    Product findByProductId(BigInteger productId);

}
