package com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.entidades.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}