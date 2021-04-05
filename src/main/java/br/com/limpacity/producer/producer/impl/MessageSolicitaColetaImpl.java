package br.com.limpacity.producer.producer.impl;

import br.com.limpacity.producer.dto.SolicitaColetaUuidDTO;
import br.com.limpacity.producer.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSolicitaColetaImpl implements Producer<SolicitaColetaUuidDTO> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.events.solicitaColeta.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.events.solicitaColeta.queueAguardando}")
    private String queueAguardando;

    @Override
    public void execute(final SolicitaColetaUuidDTO message) {
        log.info("got the RoutingKey {} - " + queueAguardando);
        rabbitTemplate.convertAndSend(exchangeName, queueAguardando, message);
        log.info("message sent - " + message);
    }
}
