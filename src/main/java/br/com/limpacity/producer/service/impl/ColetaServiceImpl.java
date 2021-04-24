package br.com.limpacity.producer.service.impl;

import br.com.limpacity.producer.dto.SolicitaColetaDTO;
import br.com.limpacity.producer.dto.SolicitaColetaUuidDTO;
import br.com.limpacity.producer.exception.ColetaNotFoundException;
import br.com.limpacity.producer.producer.ProducerColeta;
import br.com.limpacity.producer.service.ColetaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@AllArgsConstructor
public class ColetaServiceImpl implements ColetaService {

    private final ProducerColeta<SolicitaColetaUuidDTO> producerColeta;

    @Override
    public void solColeta(SolicitaColetaDTO coleta) {
        SolicitaColetaUuidDTO coletaUuid;
        coletaUuid = toColeta(coleta);
        coletaUuid.setUuid(UUID.randomUUID());

        log.info("Sending message for coleta id" + coletaUuid.toString() );
        try {
            producerColeta.executeSolicitacao(coletaUuid);
        } catch (final Exception e) {
            log.error("Error unexpected for uuid={}", coletaUuid);
            throw new ColetaNotFoundException();
        }
    }

    public static SolicitaColetaUuidDTO toColeta(SolicitaColetaDTO coleta){
        return SolicitaColetaUuidDTO
                .builder()
                .material(coleta.getMaterial())
                .municipio(coleta.getMunicipio())
                .cep(coleta.getCep())
                .endereco(coleta.getEndereco())
                .dataLimite(coleta.getDataLimite())
                .quantidade(coleta.getQuantidade())
                .reciclavel(coleta.getReciclavel())
                .integrationStatus(coleta.getIntegrationStatus())
                .build();
    }

}
