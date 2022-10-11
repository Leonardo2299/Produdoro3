package dev.wakandaacademy.produdoro.tarefa.application.repository;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

import java.util.UUID;

public interface TarefaRepository {

    Tarefa salva(Tarefa tarefa);
    void deletaTarefaPorId(UUID idTarefa);
}
