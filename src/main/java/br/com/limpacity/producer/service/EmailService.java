package br.com.limpacity.producer.service;

import br.com.limpacity.producer.dto.NotificaEmailDTO;

import java.util.List;

public interface EmailService {

    void notificaColeta(List<NotificaEmailDTO> request);
}
