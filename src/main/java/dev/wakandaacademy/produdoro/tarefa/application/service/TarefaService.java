package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaModificadaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;

import java.util.List;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaListResponse;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaService {
    
    TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest);

	List<TarefaListResponse> ordenaTarefasAsc(UUID idUsuario);
    
	List<TarefaListResponse> ordenaTarefasDesc(UUID idUsuario);
	
    Tarefa detalhaTarefa(UUID idTarefa);

    void editaTarefa(UUID idTarefa, TarefaModificadaRequest tarefaModificadaRequest);

	void statusAtivacaoTarefa(UUID idUsuario, UUID idTarefa);
}
 


