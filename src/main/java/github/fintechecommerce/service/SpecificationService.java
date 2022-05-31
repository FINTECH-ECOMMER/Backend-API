package github.fintechecommerce.service;

import github.fintechecommerce.entity.Specification;
import github.fintechecommerce.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class SpecificationService {
    public static final String KEY = "SPECIFICATIONS";
    @Autowired
    private SpecificationRepository specificationRepository;

    @Cacheable(value = KEY, unless = "#result == null")
    public List<Specification> fetchAllSpecifications() {
        return specificationRepository.findAll();
    }

    @Cacheable(value = KEY, key = "#specificationId", unless = "#result == null")
    public Specification fetchSpecificationById(BigInteger specificationId) {
        return specificationRepository.findBySpecificationId(specificationId);
    }
}
