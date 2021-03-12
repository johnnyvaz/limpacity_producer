package br.com.limpacity.producer.producer.impl;

import br.com.limpacity.producer.dto.SolicitaColetaDTO;
import br.com.limpacity.producer.producer.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSolicitaColetaImpl implements Producer<SolicitaColetaDTO> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.events.solicitaColeta.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.events.solicitaColeta.routingkey}")
    private String queueRoutingKey;

    @Override
    public void execute(final SolicitaColetaDTO message) {
        log.info("got the RoutingKey {} - " + queueRoutingKey);
        rabbitTemplate.convertAndSend(exchangeName, queueRoutingKey, message);
        log.info("message sent {} - " + exchangeName);
    }
}
