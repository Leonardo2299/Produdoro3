package dev.wakandaacademy.produdoro.tarefa.application.repository;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;


public interface TarefaRepository {
    Tarefa salva(Tarefa tarefa);

	List<Tarefa> buscaTarefaOrdenadaAsc(UUID idUsuario);

	List<Tarefa> buscaTarefaOrdenadaDesc(UUID idUsuario);
	
    Tarefa buscaTarefaPorId(UUID idTarefa);

    void inativaTarefa(UUID idUsuario);


}
