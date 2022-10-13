package dev.wakandaacademy.produdoro.tarefa.application.api;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TarefaRestController implements TarefaAPI {
	private final TarefaService tarefaService;


    @Override
    public TarefaIdResponse postNovaTarefa(TarefaRequest tarefaRequest) {
        log.info("[inicia] TarefaRestController - postNovaTarefa");
        TarefaIdResponse tarefaCriada = tarefaService.criaNovaTarefa(tarefaRequest);
        log.info("[finaliza] TarefaRestController - postNovaTarefa");
        return tarefaCriada;
    }

	@Override
	public List<TarefaListResponse> listaTarefasOrdenadasAsc(UUID idUsuario) {
		log.info("[inicia] TarefaRestController - ListaTarefasOrdenadasAsc");
		List<TarefaListResponse> tarefasOrdenadas = tarefaService.ordenaTarefasAsc(idUsuario);
		log.info("[finaliza] TarefaRestController - ListaTarefasOrdenadasAsc  ");
		return tarefasOrdenadas;
	}

	@Override
	public List<TarefaListResponse> listaTarefasOrdenadasDesc(UUID idUsuario) {
		log.info("[inicia] TarefaRestController - ListaTarefasOrdenadasDesc");
		List<TarefaListResponse> tarefasOrdenadas = tarefaService.ordenaTarefasDesc(idUsuario);
		log.info("[finaliza] TarefaRestController - ListaTarefasOrdenadasDesc");
		return tarefasOrdenadas;
	}


    @Override
    public TarefaDetalhadoResponse detalhaTarefa(UUID idTarefa) {
        log.info("[inicia] TarefaRestController - detalhaTarefa");
        Tarefa tarefa = tarefaService.detalhaTarefa(idTarefa);
        log.info("[finaliza] TarefaRestController - detalhaTarefa");
        return new TarefaDetalhadoResponse(tarefa);
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
