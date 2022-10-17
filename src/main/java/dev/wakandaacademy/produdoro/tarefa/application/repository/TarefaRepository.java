package dev.wakandaacademy.produdoro.tarefa.application.repository;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaRepository {
    Tarefa salva(Tarefa tarefa);
    void deletaTarefaPorId(UUID idTarefa);
	List<Tarefa> buscaTarefaOrdenadaAsc(UUID idUsuario);
	List<Tarefa> buscaTarefaOrdenadaDesc(UUID idUsuario);
    Tarefa buscaTarefaPorId(UUID idTarefa);
    void inativaTarefa(UUID idUsuario);
    List<Tarefa> buscaTarefaPorIdUsuario(UUID idUsuario);
}
