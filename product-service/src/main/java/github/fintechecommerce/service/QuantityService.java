package github.fintechecommerce.service;

import github.fintechecommerce.entity.Quantity;
import github.fintechecommerce.repository.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class QuantityService {
    public static final String KEY = "QUANTITIES";

    @Autowired
    private QuantityRepository quantityRepository;

    @Cacheable(value = KEY, key = "#quantityId", unless = "#result ==  null")
    public Quantity fetchQuantityById(BigInteger quantityId) {

        return quantityRepository.findByQuantityId(quantityId);
    }

    @Cacheable(value = KEY, unless = "#result ==  null")
    public List<Quantity> fetchAllQuantities() {

        return quantityRepository.findAll();
    }
}
