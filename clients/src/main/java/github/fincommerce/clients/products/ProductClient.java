package github.fincommerce.clients.products;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "PRODUCT", url = "api/V1/products")
public interface ProductClient {
    // Todo : Video 1: ProductClient22   to add client

}
