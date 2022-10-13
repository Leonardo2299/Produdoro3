package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.config.security.service.TokenService;
import dev.wakandaacademy.produdoro.handler.APIException;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaListResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaModificadaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.produdoro.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.produdoro.usuario.application.service.UsuarioService;
import dev.wakandaacademy.produdoro.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class TarefaApplicationService implements TarefaService {

	private final UsuarioService usuarioService;

	private final TarefaRepository tarefaRepository;

	private final UsuarioRepository usuarioRepository;

	private final TokenService tokenService;

	@Override
	public TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest) {
		log.info("[start] TarefaApplicationService - criaNovaTarefa");
		Tarefa tarefaCriada = tarefaRepository.salva(new Tarefa(tarefaRequest));
		log.info("[finish] TarefaApplicationService - criaNovaTarefa");
		return TarefaIdResponse.builder().idTarefa(tarefaCriada.getIdTarefa()).build();
	}

	@Override
	public List<TarefaListResponse> ordenaTarefasAsc(UUID idUsuario) {
		log.info("[inicia] TarefaSpringMongoDBService - OrdenaTarefas");
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		List<Tarefa> listaDeTarefas = tarefaRepository.buscaTarefaOrdenadaAsc(usuario.getIdUsuario());
		log.info("[finaliza] TarefaSpringMongoDBService - OrdenaTarefas");
		return TarefaListResponse.converte(listaDeTarefas);
	}

	@Override
	public List<TarefaListResponse> ordenaTarefasDesc(UUID idUsuario) {
		log.info("[inicia] TarefaSpringMongoDBService - OrdenaTarefasDesc");
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
		List<Tarefa> listaDeTarefa = tarefaRepository.buscaTarefaOrdenadaDesc(usuario.getIdUsuario());
		log.info("[finaliza] TarefaSpringMongoDBService - OrdenaTarefasDesc");
		return TarefaListResponse.converte(listaDeTarefa);
	}

	@Override
	public Tarefa detalhaTarefa(UUID idTarefa) {
		log.info("[inicia] TarefaService - detalhaTarefa");
		Tarefa tarefa = tarefaRepository.buscaTarefaPorId(idTarefa);
		log.info("[finaliza] TarefaService - detalhaTarefa");
		return tarefa;
	}

	@Override
	public void editaTarefa(UUID idTarefa, TarefaModificadaRequest tarefaModificadaRequest) {
		log.info("[start] TarefaApplicationService - editaTarefa");
		Tarefa tarefa = tarefaRepository.buscaTarefaPorId(idTarefa);
		tarefa.edita(tarefaModificadaRequest);
		tarefaRepository.salva(tarefa);
		log.info("[finish] TarefaApplicationService - editaTarefa");
	}

	@Override
	public void statusAtivacaoTarefa(UUID idUsuario, UUID idTarefa) {
		log.info("[inicia] TarefaApplicationService - statusAtivacaoTarefa");
		usuarioService.buscaUsuarioPorId(idUsuario);
		Tarefa tarefa = tarefaRepository.buscaTarefaPorId(idTarefa);
		tarefaRepository.inativaTarefa(idUsuario);
		tarefa.mudaParaAtiva();
		tarefaRepository.salva(tarefa);
		log.info("[finaliza] TarefaApplicationService - statusAtivacaoTarefa");
	}

	@Override
	public void alteraPomodoro(UUID idTarefa, String token) {
		log.info("[Inicio] - IncrementaApplicationService - alteraCliente");
		String emailUsuario = tokenService.getUsuario(token).orElseThrow();
		Optional<String> usuario = tokenService.getUsuarioByBearerToken(token);
		Tarefa tarefa = tarefaRepository.buscaTarefaPorId(idTarefa);
		validaUsuario(tarefa, emailUsuario);
		tarefa.incrementaPomodor();
		tarefaRepository.salva(tarefa);
		log.info("[Fim] - IncrementaApplicationService - alteraCliente");
	}

	public void validaUsuario(Tarefa tarefa, String usuario) {
		UsuarioCriadoResponse usuarioResponse = usuarioService.buscaUsuarioPorId(tarefa.getIdUsuario());
		if(!usuarioResponse.getEmail().equals(usuario)){
			throw APIException.build(HttpStatus.BAD_REQUEST, "Usuarios não são iguais!");
		}		
	}  
	
}
