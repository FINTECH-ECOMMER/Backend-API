package github.fintechecommerce.controller;

import github.fintechecommerce.model.GeneralResponse;
import github.fintechecommerce.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
@RequestMapping(path = "${api_prefix}/specifications")
public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @PostMapping({"", "/"})
    public GeneralResponse getProducts() {
        return new GeneralResponse(specificationService.findAllSepecification());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public GeneralResponse getProduct(@PathVariable("id") BigInteger productId) {

        return new GeneralResponse(specificationService.findSpecificationById(productId));
    }
}
