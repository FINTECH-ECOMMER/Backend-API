package github.fintechecommerce.controller;

import github.fintechecommerce.entity.Quantity;
import github.fintechecommerce.model.ResponseModel;
import github.fintechecommerce.service.QuantityService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "${api_prefix}/quantities")
public class QuantityController {
    @Autowired
    private QuantityService quantityService;

    @GetMapping({"", "/"})
    public ResponseModel<List<Quantity>> getQuantities() {
        return new ResponseModel<>(quantityService.fetchAllQuantities());
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Quantity> getQuantity(@NonNull @PathVariable("id") BigInteger quantityId) {

        return new ResponseModel<>(quantityService.fetchQuantityById(quantityId));
    }
}
