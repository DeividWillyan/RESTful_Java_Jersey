package br.com.RESTful.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.RESTful.domain.Usuario;

public class UsuarioDAO {

	static final List<Usuario> USUARIOS = new ArrayList<>();

	static void add() {
		Usuario usuario = new Usuario();
		usuario.setId(1L);
		usuario.setNome("deivid");
		usuario.setEmail("deiviid_@hotmail.com");
		usuario.setSenha("123456");
		USUARIOS.add(usuario);

		usuario = new Usuario();
		usuario.setId(2L);
		usuario.setNome("Willyan");
		usuario.setEmail("willyan@live.com");
		usuario.setSenha("0987654321");
		USUARIOS.add(usuario);

		usuario = new Usuario();
		usuario.setId(3L);
		usuario.setNome("Rodrigues");
		usuario.setEmail("rodrigues@gmail.com");
		usuario.setSenha("senha@ro123");
		USUARIOS.add(usuario);
	}

	static {
		add();
	}

	public List<Usuario> listar() {
		List<Usuario> usuarios = new ArrayList<>();
		for (Usuario usuario : USUARIOS) {
			usuarios.add(usuario);
		}
		return usuarios;
	}

	public Usuario buscarPorCodigo(Long codigo) {
		for (Usuario usuario : listar()) {
			if (usuario.getId() == codigo)
				return usuario;
		}
		return null;
	}

	public void salvar(Usuario usuario) {
		if (usuario.getNome() != null) {
			USUARIOS.add(usuario);
		} else {
			System.out.println("ERRO, usuario null");
		}
	}

	public void editar(Usuario usuario) {
		System.out.println(buscarPorCodigo(usuario.getId()));
		if (!buscarPorCodigo(usuario.getId()).equals(null)) {
			for (int i = 0; i < USUARIOS.size(); i++) {
				if (USUARIOS.get(i).getId() == usuario.getId()) {
					USUARIOS.set(i, usuario);
				}
			}
		} else {
			new Throwable("ERRO id do usuario nao encontrada");
		}
	}
	
	public void excluir(Usuario usuario) {
		if (!buscarPorCodigo(usuario.getId()).equals(null)) {
			for (int i = 0; i < USUARIOS.size(); i++) {
				if (USUARIOS.get(i).getId() == usuario.getId()) {
					USUARIOS.remove(i);
				}
			}
		} else {
			new Throwable("ERRO id do usuario nao encontrada");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
