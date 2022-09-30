package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaListResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaService {

    TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest);

	List<TarefaListResponse> BuscarTodasTarefas(UUID idUsuario);

	List<TarefaListResponse> OrdenaTarefas(UUID idUsuario);

	List<TarefaListResponse> OrdenaTarefasDesc(UUID idUsuario);
	
}
