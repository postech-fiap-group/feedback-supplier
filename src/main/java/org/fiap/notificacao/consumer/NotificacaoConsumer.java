package org.fiap.notificacao.consumer;

import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class NotificacaoConsumer {

    @Incoming("feedback-in")
    public void consumir(JsonObject mensagem) {

        System.out.println("📩 NOTIFICAÇÃO RECEBIDA");
        System.out.println("Descrição: " + mensagem.getString("descricao"));
        System.out.println("Urgente: " + mensagem.getBoolean("urgente"));
        System.out.println("Data envio: " + mensagem.getString("dataEnvio"));
        System.out.println("----------------------------------");
    }
}