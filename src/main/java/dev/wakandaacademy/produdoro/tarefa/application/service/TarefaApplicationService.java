package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaIdResponse;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaModificadaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class TarefaApplicationService implements TarefaService {

    private final TarefaRepository tarefaRepository;

    @Override
    public TarefaIdResponse criaNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[start] TarefaApplicationService - criaNovaTarefa");
        Tarefa tarefaCriada = tarefaRepository.salva(new Tarefa(tarefaRequest));
        log.info("[finish] TarefaApplicationService - criaNovaTarefa");
        return TarefaIdResponse.builder().idTarefa(tarefaCriada.getIdTarefa()).build();
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
}
