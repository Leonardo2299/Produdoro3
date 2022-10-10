package dev.wakandaacademy.produdoro.tarefa.application.api;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TarefaRestController implements TarefaAPI {

	private final TarefaService tarefaService;


    public TarefaIdResponse postNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[inicia]  TarefaRestController - postNovaTarefa  ");
        TarefaIdResponse tarefaCriada = tarefaService.criaNovaTarefa(tarefaRequest);
        log.info("[finaliza]  TarefaRestController - postNovaTarefa");
        return tarefaCriada;
    }

    @Override
    public void patchEditaTarefa(UUID idTarefa, TarefaModificadaRequest tarefaModificadaRequest) {
        log.info("[inicia]  TarefaRestController - patchEditaTarefa  ");
        tarefaService.editaTarefa(idTarefa, tarefaModificadaRequest);
        log.info("[finaliza]  TarefaRestController - patchEditaTarefa  ");
    }

	@Override
	public void ativaTarefa(UUID idUsuario, UUID idTarefa) {
		log.info("[inicia]  TarefaRestController - ativaTarefa ");
		tarefaService.statusAtivacaoTarefa(idUsuario, idTarefa);
		log.info("[finaliza]  TarefaRestController - ativaTarefa");

	}
}
