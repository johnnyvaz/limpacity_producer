package br.com.limpacity.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SolicitaColetaDTO {

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
