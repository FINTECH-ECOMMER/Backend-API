package github.fintechecommerce.repository;

import github.fintechecommerce.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface ImageRepository extends JpaRepository<Image, BigInteger> {
    Image findByImageId(BigInteger imageId);
}
