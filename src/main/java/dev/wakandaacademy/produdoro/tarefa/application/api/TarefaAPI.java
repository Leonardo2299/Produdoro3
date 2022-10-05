package dev.wakandaacademy.produdoro.tarefa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/tarefa")
public interface TarefaAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    TarefaIdResponse postNovaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);
    
    @PatchMapping("{idTarefa}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	void patchEditaTarefa(@PathVariable UUID idTarefa, 
			@RequestBody @Valid TarefaModificadaRequest tarefaModificadaRequest );

}