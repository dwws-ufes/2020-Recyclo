package br.ufes.informatica.recyclo.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.informatica.recyclo.core.domain.Coletor;
import br.ufes.informatica.recyclo.core.persistence.ColetorDAO;
import br.ufes.informatica.recyclo.core.persistence.EnderecoDAO;
import br.ufes.informatica.recyclo.core.persistence.MaterialDAO;
import br.ufes.informatica.recyclo.core.persistence.MunicipioDAO;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class ColetorServiceBean implements ColetorService {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private ColetorDAO coletorDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private MunicipioDAO municipioDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private MaterialDAO materialDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private EnderecoDAO enderecoDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public void incluirColetor(Coletor coletor) {
		// FIXME: auto-generated method stub
		return;
	}

}