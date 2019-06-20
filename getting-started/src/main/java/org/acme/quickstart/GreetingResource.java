package org.acme.quickstart;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/contador")
public class GreetingResource {

	@Inject
	EntidadRepository repositorio;

	@GET
	@Transactional
	@Path("/{nombre}")
	@Produces(TEXT_PLAIN)
	public String contador(@PathParam("nombre") String nombre) {
		Entidad entidad = repositorio.findById(nombre);

		if (entidad == null) {
			entidad = new Entidad();
			entidad.setNombre(nombre);
			repositorio.persist(entidad);
		}

		entidad.setCantidad(entidad.getCantidad() + 1);

		return printEntidad(entidad);
	}

	@GET
	@Produces(TEXT_PLAIN)
	public String listado() {
		return "Listado:" + lineSeparator() +
			repositorio.getStream().map(this::printEntidad).collect(joining(lineSeparator()));
	}
	
	private String printEntidad(Entidad entidad) {
		return entidad.getNombre() + ": " + entidad.getCantidad();
	}
}