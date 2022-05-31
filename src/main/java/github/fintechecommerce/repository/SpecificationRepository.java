package github.fintechecommerce.repository;

import github.fintechecommerce.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification, BigInteger> {
    Specification findBySpecificationId(BigInteger specificationId);

}