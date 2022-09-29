package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.IncrementaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequiredArgsConstructor
public class IncrementaContoller implements IncrementaAPI {
	
	private final IncrementaService incrementaService;
	
	@Override
	public void incrementaPomodoro(UUID idTarefa) {
		log.info("[Inicio] - IncrementaContoller - incrementaPomodoro");
		incrementaService.alteraCliente(idTarefa);
		log.info("[Fim] - IncrementaContoller - incrementaPomodoro");
	}

}
