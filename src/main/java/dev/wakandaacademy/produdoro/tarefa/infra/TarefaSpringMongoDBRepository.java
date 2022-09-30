package dev.wakandaacademy.produdoro.tarefa.infra;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface TarefaSpringMongoDBRepository extends MongoRepository<Tarefa, UUID> {

	List<Tarefa> findAllByIdUsuario(UUID idUsuario);


	List<Tarefa> findByIdUsuarioOrderByDescricao(UUID idUsuario);


	List<Tarefa> findByIdUsuarioOrderByDescricaoDesc(UUID idUsuario);

}
