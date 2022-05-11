package org.maxwell.order.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/4/24 0:04
 */

@Data
public class ProductOrder implements Serializable {

    private int id;

    private String productName;

    private int price;

    private Date creatTime;

    private int userId;

    private String userName;

    private String tradeNo;

}
