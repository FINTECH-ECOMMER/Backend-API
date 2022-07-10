package github.fintech.error.controller;

import github.fintech.error.Entity.Error;
import github.fintech.error.model.ResponseModel;
import github.fintech.error.service.ErrorService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(path = "${api_prefix}/errors")
public class ErrorController {

    @Autowired
    private ErrorService errorService;

    @GetMapping({"", "/"})
    public ResponseModel<List<Error>> getErrors() {
        return new ResponseModel<>(errorService.fetchAllErrors());
    }

    @PostMapping({"", "/"})
    public void postErrors(@RequestBody Error error) {
        errorService.postError(error);
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseModel<Error> getError(@NonNull @PathVariable("id") BigInteger errorId) {
        return new ResponseModel<>(errorService.fetchByErrorId(errorId));
    }
}
