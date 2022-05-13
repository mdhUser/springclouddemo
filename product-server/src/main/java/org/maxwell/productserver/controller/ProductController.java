package org.maxwell.productserver.controller;

import org.maxwell.productserver.entity.Product;
import org.maxwell.productserver.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/30 16:55
 */

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {


    @Value("${server.port}")
    private String port;


    @Autowired
    private ProductService productService;

    /**
     * 获取所有商品列表
     *
     * @return
     */
    @RequestMapping("/list")
    public List<Product> list() {
        return productService.listProduct();
    }

    @RequestMapping("/findById")
    public Object findById(int id) {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Product product = productService.findById(id);
        Product result = new Product();
        BeanUtils.copyProperties(product, result);
        result.setName(result.getName() + " data from port=" + port);
        return result;
    }


}