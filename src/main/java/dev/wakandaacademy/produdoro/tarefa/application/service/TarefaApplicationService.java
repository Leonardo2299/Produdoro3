package dev.wakandaacademy.produdoro.tarefa.application.service;

import dev.wakandaacademy.produdoro.tarefa.application.api.IdTarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TarefaApplicationService implements TarefaService {
	private final UsuarioService usuarioService;
	private final TarefaRepository tarefaRepository;

	@Override
	public TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest) {
		log.info("[start] TarefaSpringMongoDBService - criaNovaTarefa");
		Tarefa tarefaCriada = tarefaRepository.salva(new Tarefa(tarefaRequest));
		log.info("[finish] TarefaSpringMongoDBService - criaNovaTarefa");
		return TarefaIdResponse.builder().idTarefa(tarefaCriada.getIdTarefa()).build();
	}

	@Override
	public void statusAtivacaoTarefa(UUID idUsuario, UUID idTarefa) {
		log.info("[inicia] TarefaApplicationService - statusAtivacaoTarefa");
		usuarioService.buscaUsuarioPorId(idUsuario);
		//APAGAR (USAR OUTRO)
////		Tarefa tarefa = tarefaRepository.getTarefaById(idTarefa);
//		tarefaRepository.inativaTarefa(idUsuario);
//		tarefa.mudaParaAtiva();
//		tarefaRepository.salva(tarefa);
		log.info("[finaliza] TarefaApplicationService - statusAtivacaoTarefa");
	}



}
