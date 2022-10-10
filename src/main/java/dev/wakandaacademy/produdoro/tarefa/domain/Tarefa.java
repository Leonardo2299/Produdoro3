package dev.wakandaacademy.produdoro.tarefa.domain;

import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaModificadaRequest;
import dev.wakandaacademy.produdoro.tarefa.application.api.TarefaRequest;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Document(collection = "Tarefa")
public class Tarefa {

    @Id
    private UUID idTarefa;
    @NotBlank
    private String descricao;
    @Indexed
    private UUID idUsuario;
    @Indexed
    private UUID idArea;
    @Indexed
    private UUID idProjeto;
    private StatusTarefa status = StatusTarefa.A_FAZER;
    private StatusAtivacaoTarefa statusAtivacao;
    private int contagemPomodoro;

    public Tarefa(TarefaRequest tarefaRequest) {
        this.idTarefa = UUID.randomUUID();
        this.idUsuario = tarefaRequest.getIdUsuario();
        this.descricao = tarefaRequest.getDescricao();
        this.idArea = tarefaRequest.getIdArea();
        this.idProjeto = tarefaRequest.getIdProjeto();
        this.status = StatusTarefa.A_FAZER;
        this.statusAtivacao = StatusAtivacaoTarefa.INATIVA;
        this.contagemPomodoro = 1;
    }

    public void editada(TarefaModificadaRequest tarefaModificadaRequest) {
        this.descricao = tarefaModificadaRequest.getDescricao();
        this.contagemPomodoro = tarefaModificadaRequest.getContagemPomodoro();
    }
}
