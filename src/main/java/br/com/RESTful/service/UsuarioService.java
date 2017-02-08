package br.com.RESTful.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.RESTful.dao.UsuarioDAO;
import br.com.RESTful.domain.Usuario;

@Path("usuario")
public class UsuarioService {

	@GET
	public String listar() {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios = usuarioDAO.listar();

		Gson gson = new Gson();
		String json = gson.toJson(usuarios);

		return json;
	}

	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo") Long codigo) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.buscarPorCodigo(codigo);

		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		return json;

	}

	@POST
	public String salvar(String json) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);

		String jsonSaida = gson.toJson(usuario);
		return jsonSaida;

	}

	@PUT
	public String editar(String json) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.editar(usuario);

		String jsonSaida = gson.toJson(usuario);
		return jsonSaida;
	}

	@DELETE
	public String excluir(String json) {
		Gson gson = new Gson();
		Usuario usuario = gson.fromJson(json, Usuario.class);

		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.excluir(usuario);

		return "EXCLUIDO";

	}

}
