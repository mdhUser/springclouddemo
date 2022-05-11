package org.maxwell.order.service.impl;

import org.maxwell.order.entity.ProductOrder;
import org.maxwell.order.service.OrderService;
import org.maxwell.order.service.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/24 0:18
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private ProductClient productClient;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Override
    public ProductOrder save(int userId, int productId) {

//        方式一 启动类中配置RestTemplate
//        Map<String, Object> productMap = restTemplate.getForObject("http://product-service/api/v1/product/findById?id=" + productId, Map.class);

        //方式二
        ServiceInstance instance = loadBalancer.choose("product-service");
        String url = String.format("http://%s:%s/api/v1/product/findById?id=%d", instance.getHost(), instance.getPort(), productId);
        RestTemplate restTemplate = new RestTemplate();
        Map<String, Object> productMap = restTemplate.getForObject(url, Map.class);

        String response = productClient.findById(userId);


        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreatTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        assert productMap != null;
        productOrder.setProductName(productMap.get("name").toString());
        productOrder.setPrice((Integer) productMap.get("price"));
        return productOrder;
    }
}
