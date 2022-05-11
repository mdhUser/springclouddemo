package org.maxwell.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/12 0:45
 */
@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/api/v1/product/findById")
    String findById(@RequestParam(value = "id") Integer id);


}
