package org.acme.quickstart;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.jinq.jpa.JPAJinqStream;
import org.jinq.jpa.JinqJPAStreamProvider;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class EntidadRepository implements PanacheRepositoryBase<Entidad, String> {
	@Inject
	protected EntityManager entityManager;

	protected JinqJPAStreamProvider streams;


	@PostConstruct
	private void init() {
		if (streams == null) {
			streams = new JinqJPAStreamProvider(entityManager.getMetamodel());
		}
	}

	public JPAJinqStream<Entidad> getStream() {
		return streams.streamAll(entityManager, Entidad.class);
	}
}
