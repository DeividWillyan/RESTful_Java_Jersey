package br.com.RESTful.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

import com.google.gson.Gson;

import br.com.RESTful.domain.Usuario;

@ManagedBean
public class UsuarioClintService {

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@PostConstruct
	public void listar() {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://localhost:8080/RESTful/rest/usuario/");
		String json = caminho.request().get(String.class);

		Gson gson = new Gson();
		Usuario[] vetor = gson.fromJson(json, Usuario[].class);

		List<Usuario> usuarios = Arrays.asList(vetor);

		for (Usuario u : usuarios) {
			System.out.println(u.getNome() + " " + u.getEmail());
		}	
	}

	public void salvar(Usuario usuario) {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://localhost:8080/RESTful/rest/usuario/");

		Gson gson = new Gson();
		String json = gson.toJson(usuario);

		caminho.request().post(Entity.json(json));
	}

	public void editar(Usuario usuario) {
		Client cliente = ClientBuilder.newClient();
		WebTarget caminho = cliente.target("http://localhost:8080/RESTful/rest/usuario/");

		Gson gson = new Gson();
		String json = gson.toJson(usuario);

		caminho.request().put(Entity.json(json));
	}

//	public void excluir(String id) {
//		Client cliente = ClientBuilder.newClient();
//		WebTarget caminho = cliente.target("http://localhost:8080/RESTful/rest/usuario/").path("usuario").path(id);
//
//		Invocation.Builder builder = caminho.request();
//		builder.delete();
//	}

}
