package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;

import dev.wakandaacademy.produdoro.handler.APIException;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
public interface TarefaService {

    TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest);

	Tarefa detalhaTarefa(UUID idTarefa);

    
}
