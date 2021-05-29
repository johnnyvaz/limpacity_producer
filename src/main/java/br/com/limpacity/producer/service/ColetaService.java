package br.com.limpacity.producer.service;

import br.com.limpacity.producer.dto.SolicitaColetaDTO;
import br.com.limpacity.producer.dto.SolicitaColetaQrCodeDTO;

public interface ColetaService {

    void solColeta(SolicitaColetaDTO request);

    void solColetaQrCode(SolicitaColetaQrCodeDTO coleta, Long posto);
}
