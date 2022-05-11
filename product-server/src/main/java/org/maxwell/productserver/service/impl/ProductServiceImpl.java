package org.maxwell.productserver.service.impl;

import org.maxwell.productserver.entity.Product;
import org.maxwell.productserver.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/30 17:02
 */

@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> daoDemo = new HashMap<>();

    static {
        Product p1 = new Product(1, "iph1", 44, 220154);
        Product p2 = new Product(2, "iph2", 44, 561);
        Product p3 = new Product(3, "iph3", 44, 5334);
        Product p4 = new Product(4, "iph4", 44, 2312);
        Product p5 = new Product(5, "iph5", 44, 489);
        daoDemo.put(p1.getId(),p1);
        daoDemo.put(p2.getId(),p2);
        daoDemo.put(p3.getId(),p3);
        daoDemo.put(p4.getId(),p4);
        daoDemo.put(p5.getId(),p5);
    }

    @Override
    public List<Product> listProduct() {
        Collection<Product> collection = daoDemo.values();
        return new ArrayList<>(collection);
    }

    @Override
    public Product findById(int id) {
        return daoDemo.get(id);
    }
}
