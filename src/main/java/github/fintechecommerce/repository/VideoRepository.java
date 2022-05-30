package github.fintechecommerce.repository;

import github.fintechecommerce.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface VideoRepository extends  JpaRepository<Video, BigInteger> {
    Video findByVideoId(BigInteger VideoId);
}
