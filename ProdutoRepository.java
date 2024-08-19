package com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamentodepedidosapp.gerenciamentodepedidosapp.entidades.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
