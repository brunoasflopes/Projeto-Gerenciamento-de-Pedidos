package com.gerenciamentodepedidosapp.gerenciamentodepedidosapp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class GerenciamentodepedidosappApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciamentodepedidosappApplication.class, args);
	}

}
