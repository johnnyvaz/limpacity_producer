package br.com.limpacity.producer.producer.impl;

import br.com.limpacity.producer.dto.SendColetaQrCodeDTO;
import br.com.limpacity.producer.producer.ProducerColetaQrCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageSolicitaColetaQrCodeImpl implements ProducerColetaQrCode<SendColetaQrCodeDTO> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.events.solicitaColeta.exchange}")
    private String exchangeName;

    @Value("${spring.rabbitmq.events.solicitaColeta.queueColetaQrCode}")
    private String queueColetaQrCode;

    @Override
    public void executeSolicitacaoQrCode(final SendColetaQrCodeDTO message) {
        log.info("RoutingKey : " + queueColetaQrCode);
        rabbitTemplate.convertAndSend(exchangeName, queueColetaQrCode, message);
        log.info("mensagem enviada : " + message);
    }
}
