package br.com.limpacity.producer.service.impl;

import br.com.limpacity.producer.dto.SolicitaColetaDTO;
import br.com.limpacity.producer.dto.SolicitaColetaUuidDTO;
import br.com.limpacity.producer.exception.ColetaNotFoundException;
import br.com.limpacity.producer.producer.Producer;
import br.com.limpacity.producer.service.ColetaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ColetaServiceImpl implements ColetaService {

    private Producer<SolicitaColetaUuidDTO> producer;

    @Override
    public void solColeta(final SolicitaColetaDTO coleta) {
        SolicitaColetaUuidDTO coletaUuid = new SolicitaColetaUuidDTO();
        coletaUuid.setUuid(UUID.randomUUID());
        coletaUuid.setSolicitaColeta(coleta);

        log.info("Sending message for coleta id", coletaUuid.toString() );
        try {
            producer.execute(coletaUuid);
        } catch (final Exception e) {
            log.error("Error unexpected for uuid={}", coletaUuid);
            throw new ColetaNotFoundException();
        }
    }

}
