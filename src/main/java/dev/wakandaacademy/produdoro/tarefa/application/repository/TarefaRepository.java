package dev.wakandaacademy.produdoro.tarefa.application.repository;

import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaRepository {

    Tarefa salva(Tarefa tarefa);

	Tarefa buscaTarefaPorID(UUID idTarefa, UUID usuario);
	
}
