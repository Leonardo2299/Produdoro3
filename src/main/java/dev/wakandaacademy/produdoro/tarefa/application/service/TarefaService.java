package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;

public interface TarefaService {

    TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest);
	void statusAtivacaoTarefa(UUID idUsuario, UUID idTarefa);
	
	
}
