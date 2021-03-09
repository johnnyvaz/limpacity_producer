package br.com.limpacity.producer.converter;

import br.com.limpacity.producer.dto.ColetaDTO;
import br.com.limpacity.producer.model.ColetaModel;

import java.util.List;
import java.util.stream.Collectors;

public class ColetaConverter {

    private ColetaConverter(){

    }

    public static List<ColetaDTO> toColetaList(List<ColetaModel> coleta){
        return coleta.stream().map(ColetaConverter::toColeta).collect(Collectors.toList());
    }

    private static ColetaDTO toColeta(ColetaModel mat){
        return ColetaDTO.builder()
                .id(mat.getId())
                .quantidade(mat.getQuantidade())
                .integrationStatus(mat.getIntegrationStatus())
                .build();
    }
}
