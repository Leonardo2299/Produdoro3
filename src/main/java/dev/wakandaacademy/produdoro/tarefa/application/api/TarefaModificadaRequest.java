package dev.wakandaacademy.produdoro.tarefa.application.api;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.util.UUID;

@Getter
public class TarefaModificadaRequest {
    @NotEmpty(message = "O campo não pode estar vazio")
    private String descricao;
    private UUID idUsuario;
    private UUID idArea;
    private UUID idProjeto;
    private int contagemPomodoro;
}
