package dev.wakandaacademy.produdoro.tarefa.application.service;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaListResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.produdoro.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class TarefaApplicationService implements TarefaService {

    private final TarefaRepository tarefaRepository;
	private final UsuarioRepository usuarioRepository;

    @Override
    public TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[start] TarefaSpringMongoDBService - criaNovaTarefa");
        Tarefa tarefaCriada = tarefaRepository.salva(new Tarefa(tarefaRequest));
        log.info("[finish] TarefaSpringMongoDBService - criaNovaTarefa");
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
		
	
	
}
