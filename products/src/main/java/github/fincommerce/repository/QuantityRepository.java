package github.fincommerce.repository;

import github.fincommerce.entity.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface QuantityRepository extends JpaRepository<Quantity, BigInteger> {
    Quantity findByQuantityId(BigInteger quantityId);
}
