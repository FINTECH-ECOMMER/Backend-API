package github.fincommerce.clients.encryption;

import github.fincommerce.clients.utils.ResponseModelRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ENCRYPTION", url = "${clients.encryption.url}")
public interface EncryptionClient {
    @PostMapping(path = "encryption/encrypt")
    ResponseModelRecord<String> encryptedPassword(@RequestBody EncryptionRequest requestModel);

    @PostMapping(path = "encryption/decrypt")
    ResponseModelRecord<String> decryptedPassword(@RequestBody EncryptionRequest requestModel);
}