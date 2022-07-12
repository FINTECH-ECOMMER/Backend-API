package github.fincommerce.clients.errors;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "errors",
        url = "${clients.errors.url}"
)
public interface ErrorClient {

    @PostMapping("api/v1/errors")
    void postErrors(@RequestBody ErrorRequest error);
}
