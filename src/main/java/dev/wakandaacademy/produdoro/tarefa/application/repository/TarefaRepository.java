package dev.wakandaacademy.produdoro.tarefa.application.repository;

import java.util.List;
import java.util.UUID;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface TarefaRepository {

    Tarefa salva(Tarefa tarefa);
    
	List<Tarefa> BuscaTarefaOrdenadaAsc(UUID idUsuario);

	List<Tarefa> BuscaTarefaOrdenadaDesc(UUID idUsuario);
	
}
