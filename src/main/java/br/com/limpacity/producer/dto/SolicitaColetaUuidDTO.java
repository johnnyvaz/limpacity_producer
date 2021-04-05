package br.com.limpacity.producer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SolicitaColetaUuidDTO {

    private UUID uuid;

    private SolicitaColetaDTO solicitaColeta;

}
