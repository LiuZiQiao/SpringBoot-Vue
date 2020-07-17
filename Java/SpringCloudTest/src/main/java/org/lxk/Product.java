package org.lxk;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "product-service")

public interface Product {
    @GetMapping("api/v1/product/find")
    String findById(@RequestParam(value = "id") int id);
}
