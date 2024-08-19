package com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.entidades;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.repositories.PedidoRepository;

@Service
public class PedidoStatusConsumer {

    @Autowired
    private PedidoRepository pedidoRepository;

    @RabbitListener(queues = "pedidoStatusQueue")
    public void receiveMessage(Pedido pedido) {
        Pedido pedidoExistente = pedidoRepository.findById(pedido.getId()).orElse(null);
        if (pedidoExistente != null) {
            pedidoExistente.setStatus(pedido.getStatus());
            pedidoRepository.save(pedidoExistente);
        }
    }
}