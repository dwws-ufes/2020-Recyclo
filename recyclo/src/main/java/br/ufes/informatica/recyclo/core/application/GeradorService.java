package br.ufes.informatica.recyclo.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.informatica.recyclo.core.domain.Gerador;

/** TODO: generated by FrameWeb. Should be documented. */
@Local
public interface GeradorService extends Serializable {

	/** TODO: generated by FrameWeb. Should be documented. */
	public void incluirGerador(Gerador gerador);

}