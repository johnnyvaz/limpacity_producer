package br.com.limpacity.producer.controller;

import br.com.limpacity.producer.controller.base.BaseController;
import br.com.limpacity.producer.controller.base.ResponseBodyDTO;
import br.com.limpacity.producer.dto.NotificaEmailDTO;
import br.com.limpacity.producer.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@Tag(name = "NotificaEmailController", description = " Enviar para a fila de envio de email a notificação de coleta")
@RequestMapping(value = "/api/v1/notifica-email")
public class NotificaEmailController extends BaseController {

    private final Logger logger = Logger.getLogger(NotificaEmailController.class);

    private static final String MESSAGE_NOTICACAO_COLETA = "Notificação de Email de Coleta enviada com sucesso";

    private final EmailService emailService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Finish load success"),
            @ApiResponse(responseCode = "400", description = "Request contains invalid parameters"),
            @ApiResponse(responseCode = "500", description = "Unexpected error for request finish load")
    })
    @PostMapping
    @Operation(description = "Insere na fila RabbitMQ uma nova notificação de email de coleta")
    public ResponseEntity<ResponseBodyDTO<String>> notificaEmail(@Valid @RequestBody List<NotificaEmailDTO> email) {
        emailService.notificaColeta(email);
        return buildSuccessResponse(MESSAGE_NOTICACAO_COLETA, HttpStatus.CREATED); // TODO: ALTERAR RETORNO CONFORME STATUS DA MENSAGEM
    }
}
