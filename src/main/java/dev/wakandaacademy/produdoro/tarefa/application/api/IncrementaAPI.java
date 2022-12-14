package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/tarefa")
public interface IncrementaAPI {

    @PostMapping("/{idTarefa}/incrementa")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void incrementaPomodoro(@PathVariable UUID idTarefa, @RequestHeader(name = "Authorization") String token);
    
}