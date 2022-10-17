package dev.wakandaacademy.produdoro.tarefa.application.service;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.produdoro.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class TarefaApplicationService implements TarefaService {

    private final TarefaRepository tarefaRepository;
    private final UsuarioService usuarioService;

    @Override
    public TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[start] TarefaApplicationService - criaNovaTarefa");
        Tarefa tarefaCriada = tarefaRepository.salva(new Tarefa(tarefaRequest));
        log.info("[finish] TarefaApplicationService - criaNovaTarefa");
        return TarefaIdResponse.builder().idTarefa(tarefaCriada.getIdTarefa()).build();
    }

    @Override
    public List<Tarefa> buscaTarefasPorIdUsuario(Optional<String> idUsuario) {
        log.info("[start] TarefaApplicationService - buscaTarefasPorIdUsuario");
        String id;
        if (idUsuario.isPresent()) {
            id = idUsuario.get();
            UsuarioCriadoResponse usuario = usuarioService.buscaUsuarioPorId(UUID.fromString(id));
            List<Tarefa> listaDeTarefas = tarefaRepository.buscaTarefaPorIdUsuario(usuario.getIdUsuario());
            log.info("[finaliza] TarefaApplicationService - buscarTarefasPorIdUsuario");
            return listaDeTarefas;
        }
        return Arrays.asList();
        }
}
