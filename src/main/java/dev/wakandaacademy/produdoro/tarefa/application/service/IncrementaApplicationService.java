package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.wakandaacademy.produdoro.config.security.service.TokenService;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.produdoro.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class IncrementaApplicationService implements IncrementaService {
	private final TarefaRepository tarefaRepository;
	private final UsuarioRepository usuarioRepository;
	private final TokenService tokenService;

	@Override

	public void alteraPomodoro(UUID idTarefa, String token) {
		log.info("[Inicio] - IncrementaApplicationService - alteraCliente");
		String emailUsuario = tokenService.getUsuario(token).orElseThrow();
		Usuario usuario = this.usuarioRepository.buscaUsuarioPorEmail(emailUsuario);
		Tarefa tarefa = tarefaRepository.buscaTarefaPorID(idTarefa, usuario.getIdUsuario());
		tarefa.incrementaPomodor();
		tarefaRepository.salva(tarefa);
		log.info("[Fim] - IncrementaApplicationService - alteraCliente");

	}

}
