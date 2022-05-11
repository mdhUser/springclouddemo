package org.maxwell.productserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 商品类
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/3/30 16:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private int id;
    /**
     * 名称
     */
    private String name;
    /**
     * 价格
     */
    private int price;
    /**
     * 库存
     */
    private int store;

}
