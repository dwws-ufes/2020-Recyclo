package br.ufes.informatica.recyclo.core.application;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.informatica.recyclo.core.domain.Gerador;
import br.ufes.informatica.recyclo.core.persistence.EnderecoDAO;
import br.ufes.informatica.recyclo.core.persistence.GeradorDAO;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class GeradorServiceBean implements GeradorService {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private GeradorDAO geradorDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private EnderecoDAO enderecoDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public void incluirGerador(Gerador gerador) {
		// FIXME: auto-generated method stub
		return;
	}

}