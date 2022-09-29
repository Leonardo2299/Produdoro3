package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class IncrementaApplicationService implements IncrementaService {
	private final TarefaRepository tarefaRepository;
	@Override
	public void alteraCliente(UUID idTarefa) {
		log.info("[Inicio] - IncrementaApplicationService - alteraCliente");
		Tarefa tarefa = tarefaRepository.buscaTarefaPorID(idTarefa);
		tarefa.incrementaPomodor();
		tarefaRepository.salva(tarefa);
		log.info("[Fim] - IncrementaApplicationService - alteraCliente");
		
	}

}
