package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import dev.wakandaacademy.produdoro.handler.APIException;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class TarefaInfraRepository implements TarefaRepository {

	private final TarefaSpringMongoDBRepository tarefaSpringMongoDBRepository;

	@Override
	public Tarefa salva(Tarefa tarefa) {
		try {
			tarefaSpringMongoDBRepository.save(tarefa);
		} catch (DataIntegrityViolationException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Tarefa já cadastrada", e);
		}
		log.info("[finaliza] TarefaInfraRepository - salva");
		return tarefa;
	}

    @Override
    public Tarefa buscaTarefaPorId(UUID idTarefa) {
        log.info("[inicia] TarefaInfraRepository - buscaTarefaPorId");
        var tarefa = tarefaSpringMongoDBRepository.findById(idTarefa).orElseThrow(() ->
                APIException.build(HttpStatus.BAD_REQUEST, "tarefa não encontrada"));
        log.info("[finaliza] TarefaInfraRepository - buscaTarefaPorId");
        return tarefa;
    }

    @Override
    public List<Tarefa> buscaTarefaOrdenadaAsc(UUID idUsuario) {
		try {
			List<Tarefa> tarefas = tarefaSpringMongoDBRepository.findByIdUsuarioOrderByDescricao(idUsuario);
			return tarefas;
		} catch (APIException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Usuario não encontrado", e);
		}
	}

    @Override
    public List<Tarefa> buscaTarefaOrdenadaDesc(UUID idUsuario) {
		try {
			List<Tarefa> tarefas = tarefaSpringMongoDBRepository.findByIdUsuarioOrderByDescricaoDesc(idUsuario);
			return tarefas;
		} catch (APIException e) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Usuario não encontrado", e);
		}
	}
}
