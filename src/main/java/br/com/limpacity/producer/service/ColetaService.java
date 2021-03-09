package br.com.limpacity.producer.service;

import br.com.limpacity.producer.dto.ColetaDTO;
import br.com.limpacity.producer.model.ColetaModel;

import java.util.List;

public interface ColetaService {

    ColetaModel create(ColetaDTO coleta);

    List<ColetaDTO> findAllAndIntegrationStatus() throws Exception;

    ColetaDTO updateColeta(Long id, ColetaDTO coleta);

    Object inactiveColeta(Long id);

}
