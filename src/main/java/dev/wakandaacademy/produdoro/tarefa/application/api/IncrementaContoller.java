package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class IncrementaContoller implements IncrementaAPI {
	
	private final TarefaService tarefaService;
	
	@Override
	public void incrementaPomodoro(UUID idTarefa, String token) {
		log.info("[Inicio] - IncrementaContoller - incrementaPomodoro");
		tarefaService.alteraPomodoro(idTarefa, token);
		log.info("[Fim] - IncrementaContoller - incrementaPomodoro");
	}

}
