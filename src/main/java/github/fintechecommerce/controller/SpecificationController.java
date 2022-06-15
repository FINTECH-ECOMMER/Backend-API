package github.fintechecommerce.controller;

import github.fintechecommerce.entity.Specification;
import github.fintechecommerce.model.ResponseModel;
import github.fintechecommerce.service.SpecificationService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "${api_prefix}/z")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping({"", "/"})
    public ResponseModel<List<Specification>> getSpecifications() {
        return new ResponseModel<>(specificationService.fetchAllSpecifications());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Specification> getSpecifications(@NonNull @PathVariable("id") BigInteger productId) {

        return new ResponseModel<>(specificationService.fetchSpecificationById(productId));
    }
}
