package br.com.training.jms.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class PedidoPublisher {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${fila.pedidos}")
    private String nomeFila;

    public void enviarPedido(String mensagem) {
        System.out.println(">>> Enviando para a fila: " + mensagem);
        jmsTemplate.convertAndSend(nomeFila, mensagem);
    }
}
