INSERT INTO tb_produto(name, descricao, preco) VALUES ('Arroz', 'branco', '10');
INSERT INTO tb_produto(name, descricao, preco) VALUES ('Faijao', 'preto', '5');
INSERT INTO tb_produto(name, descricao, preco) VALUES ('Macarrao', 'parafuso', '3');

INSERT INTO tb_pedido(produto_id, quantidade, status) VALUES (1, '3', 'pendente');
INSERT INTO tb_pedido(produto_id, quantidade, status) VALUES (2, '5', 'processando');
INSERT INTO tb_pedido(produto_id, quantidade, status) VALUES (3, '20', 'concluido');
