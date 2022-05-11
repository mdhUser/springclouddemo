package org.maxwell.order.service;

import org.maxwell.order.entity.ProductOrder;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/24 0:18
 */
public interface OrderService {
    ProductOrder save(int userid, int productId);
}
