package br.com.limpacity.producer.service.impl;

import br.com.limpacity.producer.dto.MessageDTO;
import br.com.limpacity.producer.dto.SolicitaColetaDTO;
import br.com.limpacity.producer.exception.ColetaNotFoundException;
import br.com.limpacity.producer.producer.Producer;
import br.com.limpacity.producer.service.ColetaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class ColetaServiceImpl implements ColetaService {

    private Producer<SolicitaColetaDTO> producer;

    @Override
    public void solColeta(final SolicitaColetaDTO coleta) {
        final String coletaId = coleta.getId();
        log.info("Sending message for coleta id", coletaId);
        try {
            producer.execute(coleta);
        } catch (final Exception e) {
            log.error("Error unexpected for loadId={}", coletaId);
            throw new ColetaNotFoundException();
        }
    }


}
