package dev.wakandaacademy.produdoro.tarefa.application.service;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaModificadaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;

import java.util.UUID;

public interface TarefaService {
    TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest);

    void editaTarefa(UUID idTarefa, TarefaModificadaRequest tarefaModificadaRequest);
}
