package br.com.limpacity.producer.service.impl;

import br.com.limpacity.producer.dto.NotificaEmailDTO;
import br.com.limpacity.producer.exception.EmailNotFoundException;
import br.com.limpacity.producer.producer.ProducerEmail;
import br.com.limpacity.producer.service.EmailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final ProducerEmail<NotificaEmailDTO> producerEmail;

    public void notificaColeta(List<NotificaEmailDTO> email) {

        log.info("Sending message = " + email.toString());
        try {
            email.forEach(producerEmail::executeNotifica);
        } catch (final Exception e) {
            log.error("Error unexpected for ={}", email);
            throw new EmailNotFoundException();
        }
    }

}
