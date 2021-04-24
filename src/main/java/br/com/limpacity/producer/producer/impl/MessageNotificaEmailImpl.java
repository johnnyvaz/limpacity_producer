package br.com.limpacity.producer.producer.impl;

import br.com.limpacity.producer.dto.NotificaEmailDTO;
import br.com.limpacity.producer.producer.ProducerEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class MessageNotificaEmailImpl implements ProducerEmail<NotificaEmailDTO> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.events.solicitaColeta.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.events.solicitaColeta.queueEmail}")
    private String queueEmail;

    public void executeNotifica(final NotificaEmailDTO message) {
        log.info("got the RoutingKey {} - " + queueEmail);
        rabbitTemplate.convertAndSend(exchangeName, queueEmail, message);
        log.info("message sent - " + message);
    }
}
