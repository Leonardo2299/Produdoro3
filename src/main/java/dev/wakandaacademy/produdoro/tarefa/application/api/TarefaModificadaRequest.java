package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.constraints.NotEmpty;

import dev.wakandaacademy.produdoro.tarefa.domain.StatusAtivacaoTarefa;
import dev.wakandaacademy.produdoro.tarefa.domain.StatusTarefa;
import lombok.Getter;

@Getter
public class TarefaModificadaRequest {
	@NotEmpty(message = "O campo não pode estar vazio")
	private String descricao;
	private StatusTarefa status;
	private StatusAtivacaoTarefa statusAtivacao;
	private int contagemPomodoro;
}
