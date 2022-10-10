package dev.wakandaacademy.produdoro.tarefa.application.service;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaModificadaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class TarefaApplicationService implements TarefaService {
	private final UsuarioService usuarioService;
	private final TarefaRepository tarefaRepository;

        @Override
    public TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[start] TarefaApplicationService - criaNovaTarefa");
        Tarefa tarefaCriada = tarefaRepository.salva(new Tarefa(tarefaRequest));
        log.info("[finish] TarefaApplicationService - criaNovaTarefa");
        return TarefaIdResponse.builder().idTarefa(tarefaCriada.getIdTarefa()).build();
    }

    @Override
    public void editaTarefa(UUID idTarefa, TarefaModificadaRequest tarefaModificadaRequest) {
        log.info("[start] TarefaApplicationService - editaTarefa");
        Tarefa tarefa = tarefaRepository.buscaTarefaPorId(idTarefa);
        tarefa.editada(tarefaModificadaRequest);
        tarefaRepository.salva(tarefa);
        log.info("[finish] TarefaApplicationService - editaTarefa");
    }

    @Override
    public void statusAtivacaoTarefa(UUID idUsuario, UUID idTarefa) {
        log.info("[inicia] TarefaApplicationService - statusAtivacaoTarefa");
        usuarioService.buscaUsuarioPorId(idUsuario);
        //APAGAR (USAR OUTRO)
////		Tarefa tarefa = tarefaRepository.getTarefaById(idTarefa);
//		tarefaRepository.inativaTarefa(idUsuario);
        //tarefa.mudaParaAtiva();
//		tarefaRepository.salva(tarefa);
        log.info("[finaliza] TarefaApplicationService - statusAtivacaoTarefa");
    }
}
