package br.ufes.informatica.recyclo.core.application;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.ufes.informatica.recyclo.core.domain.Gerador;
import br.ufes.informatica.recyclo.core.domain.Oferta;

/** TODO: generated by FrameWeb. Should be documented. */
@Local
public interface OfertaService extends Serializable {

	/** TODO: generated by FrameWeb. Should be documented. */
	public boolean incluirOferta(Oferta oferta);

	public List<Oferta> getOfertasGerador(Gerador gerador);
	
	public List<Oferta> obterListaOfertasDisponiveis();
	
	public Oferta retornarOferta(Long idOferta);

}