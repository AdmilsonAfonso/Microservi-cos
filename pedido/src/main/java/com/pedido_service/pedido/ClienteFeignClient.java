package com.pedido_service.pedido;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cliente")
public interface ClienteFeignClient {

    @GetMapping("/clientes/{id}")
    Object buscarCliente(@PathVariable Long id);

    @GetMapping("/clientes")
    List clientes();
}