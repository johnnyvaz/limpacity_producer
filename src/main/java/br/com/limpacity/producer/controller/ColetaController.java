package br.com.limpacity.producer.controller;

import br.com.limpacity.producer.controller.base.BaseController;
import br.com.limpacity.producer.controller.base.ResponseBodyDTO;
import br.com.limpacity.producer.dto.SolicitaColetaDTO;
import br.com.limpacity.producer.service.ColetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Tag(name = "ColetaController", description = " (verificar o que faz sentido) para solicitação de coleta")
@RequestMapping(value = "/api/v1/coleta")
public class ColetaController extends BaseController {

    private final Logger logger = Logger.getLogger(ColetaController.class);

    private static final String MESSAGE_SOLICITACAO_COLETA = "Solicitação de Coleta enviada com sucesso";

    @Autowired
    private final ColetaService coletaService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Finish load success"),
            @ApiResponse(responseCode = "400", description = "Request contains invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Unexpected error for request finish load")
    })
    @PostMapping
    @Operation(description = "Insere na fila RabbitMQ uma nova solicitação de coleta")
    public ResponseEntity<ResponseBodyDTO<String>> solColeta(@Valid @RequestBody SolicitaColetaDTO request) {
        System.out.println("Request no controller" + request);
        coletaService.solColeta(request);
        return buildSuccessResponse(MESSAGE_SOLICITACAO_COLETA, HttpStatus.OK); // TODO: ALTERAR RETORNO CONFORME STATUS DA MENSAGEM
    }

}
