package dev.wakandaacademy.produdoro.tarefa.application.api;

import java.util.UUID;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;

@Getter
public class TarefaModificadaRequest {
	@NotEmpty(message = "O campo não pode estar vazio")
	private String descricao;
	private UUID idUsuario;
	private UUID idArea;
	private UUID idProjeto;
	private int contagemPomodoro;
}
