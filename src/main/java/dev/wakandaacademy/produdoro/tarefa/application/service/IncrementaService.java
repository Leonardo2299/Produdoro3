package dev.wakandaacademy.produdoro.tarefa.application.service;

import java.util.UUID;

import javax.validation.Valid;

public interface IncrementaService {

	void alteraPomodoro(@Valid UUID idTarefa,@Valid String jwt);

}
