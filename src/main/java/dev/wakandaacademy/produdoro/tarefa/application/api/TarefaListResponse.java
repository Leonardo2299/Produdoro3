package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.List;
import java.util.stream.Collectors;

import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.Value;

@Value
public class TarefaListResponse {
	
	   private String descricao;
	    
		public static List<TarefaListResponse> converte(List<Tarefa> listaTarefas) {
			
			return listaTarefas.stream()
					.map(t -> new TarefaListResponse(t))
					.collect(Collectors.toList());
		}


		public TarefaListResponse(Tarefa t) {
			this.descricao = t.getDescricao();
		}
		


}
