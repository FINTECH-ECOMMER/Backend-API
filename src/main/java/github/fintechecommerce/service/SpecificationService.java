package github.fintechecommerce.service;

import github.fintechecommerce.entity.Specification;
import github.fintechecommerce.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class SpecificationService {

    @Autowired
    private SpecificationRepository specificationRepository;


    public Specification saveSpecification(Specification specification) {
        return specificationRepository.save(specification);
    }

    public Specification findSpecificationById(BigInteger specificationId) {

        return specificationRepository.findBySpecificationId(specificationId);
    }
}
