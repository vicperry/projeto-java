package com.vicperry.projetojava.model.repository;

import com.vicperry.projetojava.model.domain.Usuario;

public class AcessoRepository {
	public static Usuario autenticar(Usuario usuario) {
		if(usuario.getEmail().equalsIgnoreCase(usuario.getSenha())) {
			return new Usuario("Administrador", usuario.getEmail(), usuario.getSenha());
		}
		
		return null;
	}
}
