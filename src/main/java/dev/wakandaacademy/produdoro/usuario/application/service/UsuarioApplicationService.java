package dev.wakandaacademy.produdoro.usuario.application.service;

import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.produdoro.usuario.application.api.UsuarioNovoRequest;

import java.util.UUID;

public interface UsuarioApplicationService {
	UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo);

    UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario);

	void mudaStatusParaFoco(UUID idUsuario);

    void alteraStatusPausaCurta(UUID idUsuario);

	void alteraStatusPausaLonga(UUID idUsuario);
	
}
