package dev.wakandaacademy.produdoro.tarefa.application.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import dev.wakandaacademy.produdoro.tarefa.application.repository.TarefaRepository;
import dev.wakandaacademy.produdoro.tarefa.domain.Tarefa;
import dev.wakandaacademy.produdoro.usuario.application.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@RunWith(MockitoJUnitRunner.class)
@RequiredArgsConstructor
class TarefaApplicationServiceTest {

	@InjectMocks
	private TarefaApplicationService classe;
	
	@Mock
	private final TarefaRepository tarefaRepository;
	@Mock
	private final UsuarioRepository usuarioRepository;
	
	@Test
	public void verificarSeRealmenteSalvaTest() {
		//DADO - GIVEN
		Tarefa tarefa = new Tarefa();
		tarefa.setDescricao("teste unitario");
		//QUANDO - WHEN
		classe.criaNovaTarefa(tarefa);
		//ENTAO - THEN
		
	}

}
