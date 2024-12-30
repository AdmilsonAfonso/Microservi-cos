package com.pedido_service.pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "produto")
public interface ProdutoFeignClient {

    @GetMapping("/produtos/{id}")
    Object buscarProduto(@PathVariable Long id);
}