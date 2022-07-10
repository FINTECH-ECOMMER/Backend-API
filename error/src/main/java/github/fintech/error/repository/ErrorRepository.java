package github.fintech.error.repository;

import github.fintech.error.Entity.Error;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface ErrorRepository extends JpaRepository<Error, BigInteger> {

    Error findByErrorId(BigInteger errorId);
}
