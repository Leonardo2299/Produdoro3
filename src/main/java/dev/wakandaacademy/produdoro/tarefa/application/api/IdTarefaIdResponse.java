package dev.wakandaacademy.produdoro.tarefa.application.api;

import dev.wakandaacademy.produdoro.tarefa.domain.StatusAtivacaoTarefa;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import lombok.Value;

import java.util.UUID;

//EXCLUIR ESSA CLASSE APÓS TESTAR
@Value
public class IdTarefaIdResponse {
    private UUID idTarefa;
    private StatusAtivacaoTarefa statusAtivacao;

//EXCLUIR ESSA CLASSE APÓS TESTAR
    public IdTarefaIdResponse(Tarefa tarefa) {
        this.idTarefa = tarefa.getIdTarefa();
        this.statusAtivacao = tarefa.getStatusAtivacao();
    }
}
