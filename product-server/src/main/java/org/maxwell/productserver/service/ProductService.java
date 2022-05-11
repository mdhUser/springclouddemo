package org.maxwell.productserver.service;

import org.maxwell.productserver.entity.Product;

import java.util.List;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/30 17:00
 */
public interface ProductService {

    /**
     *  商品列表
     * @return
     */
    List<Product> listProduct();

    /**
     *  按 ID 查找
     * @param id
     * @return
     */
    Product findById(int id);

}
