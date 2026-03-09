package br.com.training.jms.controller;

import br.com.training.jms.messaging.PedidoPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoPublisher publisher;

    @GetMapping("/enviar")
    public String disparar(@RequestParam String msg) {
        publisher.enviarPedido(msg);
        return "Mensagem enviada: " + msg;
    }
}
