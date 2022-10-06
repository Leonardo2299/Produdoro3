package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import dev.wakandaacademy.produdoro.tarefa.application.service.TarefaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

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
	public List<TarefaListResponse> ListaTarefasOrdenadasAsc(UUID idUsuario) {
		log.info("[inicia]  TarefaRestController - ListaTarefasOrdenadasAsc  ");
		List<TarefaListResponse> tarefasOrdenadas = tarefaService.OrdenaTarefasAsc(idUsuario);
		log.info("[finaliza]  TarefaRestController - ListaTarefasOrdenadasAsc  ");
		return tarefasOrdenadas;
	}

	@Override
	public List<TarefaListResponse> ListaTarefasOrdenadasDesc(UUID idUsuario) {
		log.info("[inicia]  TarefaRestController - ListaTarefasOrdenadasDesc  ");
		List<TarefaListResponse> tarefasOrdenadas = tarefaService.OrdenaTarefasDesc(idUsuario);
		log.info("[finaliza]  TarefaRestController - ListaTarefasOrdenadasDesc  ");
		return tarefasOrdenadas;
	}


}
