package com.componente.injecao.dependecias.Services;

import com.componente.injecao.dependecias.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

        public double shipment(Order order){
            double total = 0.0;
            if (order.getBasic() < 100.0) {
                total = 20.0;
            } else if (order.getBasic() >= 100.0 && order.getBasic() <= 200.0) {
                total =  12.0;
            } else {
                total += total ;
            }
            return total;
        }

}
