package br.ufes.informatica.recyclo.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.informatica.recyclo.core.domain.Coletor;

/** TODO: generated by FrameWeb. Should be documented. */
@Local
public interface ColetorService extends Serializable {

	/** TODO: generated by FrameWeb. Should be documented. */
	public boolean incluirColetor(Coletor coletor);

}