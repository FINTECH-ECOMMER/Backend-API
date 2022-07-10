package github.fintech.error.controller;

import github.fintech.error.Entity.Error;
import github.fintech.error.model.ResponseModel;
import github.fintech.error.service.ErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void postErrors(@RequestBody Error error){
        errorService.postError(error);
    }
}
