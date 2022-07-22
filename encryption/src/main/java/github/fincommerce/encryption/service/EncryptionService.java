package github.fincommerce.encryption.service;

import github.fincommerce.encryption.components.EncryptorAesGcmPassword;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static github.fincommerce.encryption.config.Config.UTF_8;

@Service
@AllArgsConstructor
public class EncryptionService {

    public String EncryptPass(String message, String password) {
        try {
            return EncryptorAesGcmPassword.encrypt(message.getBytes(UTF_8), password);

        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }

    public String DecryptPass(String message, String password) {
        try {
            return EncryptorAesGcmPassword.decrypt(message, password);

        } catch (Exception e) {
            e.printStackTrace();

            return "";
        }
    }
}
