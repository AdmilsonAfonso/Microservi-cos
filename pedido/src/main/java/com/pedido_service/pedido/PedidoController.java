package com.pedido_service.pedido;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;


    @Autowired
    private ClienteFeignClient clienteFeignClient;

    @Autowired
    private ProdutoFeignClient produtoFeignClient;

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }


//usa a lista de clientes vindo dos clientes
    @GetMapping("/cli")
    public List<Pedido> listarClie() {
        return clienteFeignClient.clientes();
    }


    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido) {
        // Validações
        clienteFeignClient.buscarCliente(pedido.getClienteId());
        produtoFeignClient.buscarProduto(pedido.getProdutoId());

        // Salvar pedido
        return pedidoRepository.save(pedido);
    }
}