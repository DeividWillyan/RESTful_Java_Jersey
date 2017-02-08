package br.com.RESTful.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class RestConfig extends ResourceConfig { 

	public RestConfig() {
		packages("br.com.RESTful.service");
	}
	
	
}
