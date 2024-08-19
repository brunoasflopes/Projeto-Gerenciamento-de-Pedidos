package com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.entidades.Pedido;
import com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.entidades.StatusPedido;
import com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.repositories.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
      
    private static final String EXCHANGE_NAME = "pedidoExchange";
    private static final String ROUTING_KEY = "pedido.status";

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedido) {
        pedido.setId(id);
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido alterarStatus(Long id, StatusPedido status) {
        Pedido pedido = buscarPorId(id);
        if (pedido != null) {
            pedido.setStatus(status);
            rabbitTemplate.convertAndSend(EXCHANGE_NAME, ROUTING_KEY, pedido);
        }
        return pedido;
    }

}