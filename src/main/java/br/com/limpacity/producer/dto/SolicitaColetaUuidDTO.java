package br.com.limpacity.producer.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
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

    @NotEmpty
    private String material;

    @NotEmpty
    private String endereco;

    @NotEmpty
    private String numero;

    @NotEmpty
    private String municipio;

    @NotEmpty
    private String cep;

    private Boolean reciclavel;

    private Date dataLimite;

    private Long quantidade;

    private String integrationStatus;

}
