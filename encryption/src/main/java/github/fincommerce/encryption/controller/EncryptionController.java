package github.fincommerce.encryption.controller;

import github.fincommerce.encryption.model.RequestModel;
import github.fincommerce.encryption.service.EncryptionService;
import github.fincommerce.clients.utils.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "${api_prefix}/encryption")
@AllArgsConstructor
@Slf4j
public class EncryptionController {

    private final EncryptionService encryptionService;

    @PostMapping({"/encrypt", "/encrypt/"})
    public ResponseModel<String> encryptedPassword(@Valid @RequestBody RequestModel requestModel) {
        var result = encryptionService.EncryptPass(requestModel.message(), requestModel.password());

        return new ResponseModel<>(result);
    }

    @PostMapping({"/decrypt", "/decrypt/"})
    public ResponseModel<String> DecryptPassword(@Valid @RequestBody RequestModel requestModel) {
        var result = encryptionService.DecryptPass(requestModel.message(), requestModel.password());
        return new ResponseModel<>(result);
    }
}
