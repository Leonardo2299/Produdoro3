package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaListResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaModificadaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaService {
    
    TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest);
    void deletaTarefaPorId(UUID idTarefa);

	List<TarefaListResponse> ordenaTarefasAsc(UUID idUsuario);
    
	List<TarefaListResponse> ordenaTarefasDesc(UUID idUsuario);
	
    Tarefa detalhaTarefa(UUID idTarefa);

    void editaTarefa(UUID idTarefa, TarefaModificadaRequest tarefaModificadaRequest);

	void statusAtivacaoTarefa(UUID idUsuario, UUID idTarefa);

	void alteraPomodoro(@Valid UUID idTarefa, @Valid String token);

}
 


