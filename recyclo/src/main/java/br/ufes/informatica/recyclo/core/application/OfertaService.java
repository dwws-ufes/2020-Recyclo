package br.ufes.informatica.recyclo.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.informatica.recyclo.core.domain.Oferta;

/** TODO: generated by FrameWeb. Should be documented. */
@Local
public interface OfertaService extends Serializable {

	/** TODO: generated by FrameWeb. Should be documented. */
	public void incluirOferta(Oferta oferta);

}