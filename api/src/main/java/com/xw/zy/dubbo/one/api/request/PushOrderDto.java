package com.xw.zy.dubbo.one.api.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xw
 * @date 2019/5/7 16:44
 */
@Data
@ToString
public class PushOrderDto implements Serializable {
    //商品id
    private Integer itemId;
    //商品数量
    private Integer total;
    //客户姓名
    private String customerName;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
