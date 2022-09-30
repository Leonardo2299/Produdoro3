package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

@RestController
@RequestMapping("/v1/tarefa")
public interface TarefaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TarefaIdResponse postNovaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);
    
    @GetMapping("/{idUsuario}")
	@ResponseStatus(code = HttpStatus.OK)
	List<TarefaListResponse> ListaTodosProdutos(@PathVariable UUID idUsuario);
    
    @GetMapping("/ordem-a-z/{idUsuario}")
   	@ResponseStatus(code = HttpStatus.ACCEPTED)
   	List<TarefaListResponse> ListaTarefasOrdenadasAsc(@PathVariable UUID idUsuario);
       
    @GetMapping("/ordem-z-a/{idUsuario}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    List<TarefaListResponse> ListaTarefasOrdenadasDesc(@PathVariable UUID idUsuario);
    
    
}
