package br.com.training.jms.messaging;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoReceiver {

    @JmsListener(destination = "${fila.pedidos}")
    public void processarPedido(String mensagem) {
        // Simula um processamento pesado
        System.out.println("<<< Mensagem recebida da fila: " + mensagem);

        if(mensagem.contains("Erro")) {
            throw new RuntimeException("Simulando erro para teste de Rollback");
        }
    }
}
