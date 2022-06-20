package github.fintechecommerce.repository;

import github.fintechecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface CategoryRepository extends JpaRepository<Category, BigInteger> {

    Category findByCategoryId(BigInteger categoryId);
}
