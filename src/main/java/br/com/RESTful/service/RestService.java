package br.com.RESTful.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("aqui")
public class RestService {

	@GET
	public String exibir() {
		return "Olá Deivid - Introdução a RESTful";
	}
}
