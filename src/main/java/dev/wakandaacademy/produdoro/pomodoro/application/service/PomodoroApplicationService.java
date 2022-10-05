package dev.wakandaacademy.produdoro.pomodoro.application.service;

import java.util.UUID;

import dev.wakandaacademy.produdoro.pomodoro.domain.ConfiguracaoPadrao;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;

public interface PomodoroApplicationService {
	ConfiguracaoPadrao getConfiguracaoPadrao();
	
	
}
