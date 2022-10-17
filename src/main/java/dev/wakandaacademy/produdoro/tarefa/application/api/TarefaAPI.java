package dev.wakandaacademy.produdoro.tarefa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/tarefa")
public interface TarefaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TarefaIdResponse postNovaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    List<TarefaUsuarioListResponse> listaTarefasPorIdUsuario(@RequestParam("idUsuario") Optional<String> idUsuario);

    @DeleteMapping(value = "/{idTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteTarefaPorId(@PathVariable UUID idTarefa);
    
    @GetMapping("/ordem-a-z/{idUsuario}")
   	@ResponseStatus(code = HttpStatus.ACCEPTED)
   	List<TarefaListResponse> listaTarefasOrdenadasAsc(@PathVariable UUID idUsuario);
       
    @GetMapping("/ordem-z-a/{idUsuario}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    List<TarefaListResponse> listaTarefasOrdenadasDesc(@PathVariable UUID idUsuario);
    
    @GetMapping("/{idTarefa}")
    @ResponseStatus(code = HttpStatus.OK)
    TarefaDetalhadoResponse detalhaTarefa(@PathVariable UUID idTarefa);

    @PatchMapping("/{idTarefa}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void patchEditaTarefa(@PathVariable UUID idTarefa,
                          @RequestBody @Valid TarefaModificadaRequest tarefaModificadaRequest);

    @PostMapping("/{idTarefa}/status")
    @ResponseStatus(code = HttpStatus.CREATED)
    void ativaTarefa(@RequestParam UUID idUsuario, @PathVariable UUID idTarefa);
}
