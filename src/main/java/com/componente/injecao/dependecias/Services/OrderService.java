package com.componente.injecao.dependecias.Services;


import com.componente.injecao.dependecias.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ShippingService shippingService;

    public double total(Order order) {
        double total = 0.0;
        if (order.getBasic() >= 100.0 && order.getBasic() <= 200.0) {
             total = order.getBasic() + shippingService.shipment(order)
                     - (order.getBasic() * order.getDiscount() / 100);
        } else if (order.getBasic() >= 200.0) {
            total = order.getBasic() + shippingService.shipment(order)
                    - (order.getBasic() * order.getDiscount() / 100);
        } else {
            total = order.getBasic() + shippingService.shipment(order);
        }
        return total;
    }

}
