package dev.wakandaacademy.produdoro.tarefa.infra;

import java.util.UUID;



import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
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
	private final MongoTemplate mongoTemplate;

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

	// APAGAR
	@Override
	public Tarefa getTarefaById(UUID idTarefa) {
		log.info("[INICIA] TarefaInfraRepository - getTarefaById");
		Tarefa tarefa = tarefaSpringMongoDBRepository.findByIdTarefa(idTarefa);
		log.info("[FINALIZA] TarefaInfraRepository - getTarefaById");
		return tarefa;
	}

	@Override
	public void inativaTarefa(UUID idUsuario) {
		log.info("[inicia] TarefaInfraRepository - inativaTarefa");
		Query query = new Query();
		query.addCriteria(Criteria.where("idUsuario").is(idUsuario));
		Update update = new Update();
		update.set("statusAtivacao", "INATIVA");
		mongoTemplate.updateMulti(query, update, Tarefa.class);
		log.info("[finaliza] TarefaInfraRepository - inativaTarefa");
	}
}
