package br.ufes.informatica.recyclo.core.persistence;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.informatica.recyclo.core.domain.Coletor;
import br.ufes.informatica.recyclo.core.domain.Material;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class MaterialDAOJPA extends BaseJPADAO<Material> implements MaterialDAO {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@PersistenceContext
	private EntityManager entityManager;

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public Collection obterMaterialColetor(Coletor coletor) {
		// FIXME: auto-generated method stub
		return null;
	}

}