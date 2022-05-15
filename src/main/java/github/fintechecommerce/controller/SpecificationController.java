package github.fintechecommerce.controller;

import github.fintechecommerce.entity.Specification;
import github.fintechecommerce.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigInteger;

public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @PostMapping("")
    public Specification saveSpecification(@RequestBody Specification specification) {
        return specificationService.saveSpecification(specification);
    }

    @GetMapping("/{id}")
    public Specification getSpecification(@PathVariable("id") BigInteger specificationId) {
        return specificationService.findSpecificationById(specificationId);
    }
}
