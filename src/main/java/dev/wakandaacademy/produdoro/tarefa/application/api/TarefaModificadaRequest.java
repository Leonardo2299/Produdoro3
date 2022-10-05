package dev.wakandaacademy.produdoro.tarefa.application.api;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;

@Getter
public class TarefaModificadaRequest {
	@NotEmpty(message = "O campo não pode estar vazio")
	private String descricao;
	private int contagemPomodoro;
}
