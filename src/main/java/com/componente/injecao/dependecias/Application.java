package com.componente.injecao.dependecias;

import com.componente.injecao.dependecias.Services.OrderService;
import com.componente.injecao.dependecias.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.awt.desktop.SystemSleepEvent;
import java.text.Format;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
//@ComponentScan(basePackages = "com.componente.injecao.dependecias")
public class Application implements CommandLineRunner {

    @Autowired
    private OrderService orderService;

    private Order order;

    @Autowired
    public Application(OrderService orderService) {
        this.orderService = orderService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        List<Order> list = new ArrayList<>();

        System.out.println();
        System.out.println("******************Componentes e injeção de dependência******************");
        System.out.println();

        System.out.println("Digite o número de pedido a fazer");
        int n = sc.nextInt();
        System.out.println();

        for (int i = 1; i <= n; i++) {
            System.out.print("Digite o código: ");
            Integer code = sc.nextInt();
            System.out.print("valor básico: ");
            double basic = sc.nextDouble();
            System.out.print("porcentagem de desconto): ");
            double discount = sc.nextDouble();
            System.out.println();
            list.add(new Order(code, basic, discount));
        }

        for (Order order1 : list) {
            System.out.println("Pedido código " + order1.getCode());
            System.out.println("Valor total: " + String.format("%.2f", orderService.total(order1)));
            System.out.println();
        }

        sc.close();
    }


}
