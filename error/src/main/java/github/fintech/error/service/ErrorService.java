package github.fintech.error.service;

import github.fintech.error.Entity.Error;
import github.fintech.error.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;
import java.util.List;

@Service
public class ErrorService {
    public static final String KEY = "ERRORS";

    @Autowired
    private ErrorRepository errorRepository;

    @Cacheable(value = KEY, unless = "#result == null")
    public List<Error> fetchAllErrors() {
        return errorRepository.findAll();
    }

    public Error postError(@RequestBody Error error) {
        return errorRepository.saveAndFlush(error);
    }
}
