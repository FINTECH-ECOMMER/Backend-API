package github.fincommerce.encryption.model;

import javax.validation.constraints.NotBlank;
public record RequestModel(@NotBlank(message = "Message is Blank")
                           String message, String password) {
}
