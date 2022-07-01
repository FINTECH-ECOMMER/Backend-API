package github.fincommerce.controller;

import github.fincommerce.entity.Quantity;
import github.fincommerce.model.ResponseModel;
import github.fincommerce.service.QuantityService;
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
