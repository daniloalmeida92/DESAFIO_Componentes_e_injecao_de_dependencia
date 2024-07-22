package com.componente.injecao.dependecias.entities;

import com.componente.injecao.dependecias.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

public class Order {

    private Integer code;
    private Double basic;
    private Double discount;

    public Order() {
    }
    @Autowired
    OrderService orderService;

    public Order(Integer code, Double basic, Double discount) {
        this.code = code;
        this.basic = basic;
        this.discount = discount;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
