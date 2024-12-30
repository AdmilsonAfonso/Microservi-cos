package com.cliente_service.CLIENTE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public Cliente buscarCliente(@PathVariable Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> new  RuntimeException("Cliente não encontrado"));
    }

    @PostMapping
    public Cliente adicionarCliente(@RequestBody Cliente cliente) {

        return clienteRepository.save(cliente);
    }
}
