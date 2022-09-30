package dev.wakandaacademy.produdoro.tarefa.application.api;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

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
	public List<TarefaListResponse> ListaTodosProdutos(UUID idUsuario) {
		log.info("[inicia]  TarefaRestController - ListaTodosProdutos  ");
		List<TarefaListResponse> listaTarefas = tarefaService.BuscarTodasTarefas(idUsuario);
		log.info("[finaliza]  TarefaRestController - ListaTodosProdutos  ");
		return listaTarefas;
	}

	@Override
	public List<TarefaListResponse> ListaTarefasOrdenadasAsc(UUID idUsuario) {
		log.info("[inicia]  TarefaRestController - ListaTarefasOrdenadasAsc  ");
		List<TarefaListResponse> tarefas = tarefaService.OrdenaTarefas(idUsuario);
		log.info("[finaliza]  TarefaRestController - ListaTarefasOrdenadasAsc  ");
		return tarefas;
	}

	@Override
	public List<TarefaListResponse> ListaTarefasOrdenadasDesc(UUID idUsuario) {
		log.info("[inicia]  TarefaRestController - ListaTarefasOrdenadasDesc  ");
		List<TarefaListResponse> tarefas = tarefaService.OrdenaTarefasDesc(idUsuario);
		log.info("[finaliza]  TarefaRestController - ListaTarefasOrdenadasDesc  ");
		return tarefas;
	}
}
