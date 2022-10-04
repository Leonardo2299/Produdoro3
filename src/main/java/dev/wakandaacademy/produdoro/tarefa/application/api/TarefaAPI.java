package dev.wakandaacademy.produdoro.tarefa.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioCriadoResponse;

import java.util.UUID;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/tarefa")
public interface TarefaAPI {

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	TarefaIdResponse postNovaTarefa(@RequestBody @Valid TarefaRequest tarefaRequest);


	@PostMapping("/{idTarefa}/status")
	@ResponseStatus(code = HttpStatus.CREATED)
	void ativaTarefa(@RequestParam UUID idUsuario, @PathVariable UUID idTarefa);



//APAGAR
	@GetMapping(value = "/{idTarefa}")
	@ResponseStatus(code = HttpStatus.OK)
	IdTarefaIdResponse pegarATarefaId(@PathVariable UUID idTarefa);
}
