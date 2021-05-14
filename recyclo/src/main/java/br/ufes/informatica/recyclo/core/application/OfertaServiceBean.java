package br.ufes.informatica.recyclo.core.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import br.ufes.informatica.recyclo.core.domain.Endereco;
import br.ufes.informatica.recyclo.core.domain.Gerador;
import br.ufes.informatica.recyclo.core.domain.Oferta;
import br.ufes.informatica.recyclo.core.persistence.EnderecoDAO;
import br.ufes.informatica.recyclo.core.persistence.MaterialDAO;
import br.ufes.informatica.recyclo.core.persistence.OfertaDAO;

/** TODO: generated by FrameWeb. Should be documented. */
@Stateless
public class OfertaServiceBean implements OfertaService {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private OfertaDAO ofertaDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private EnderecoDAO enderecoDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private MaterialDAO materialDAO;

	/** TODO: generated by FrameWeb. Should be documented. */
	@Override
	public boolean incluirOferta(Oferta oferta) {
		ofertaDAO.save(oferta);
		return true;
	}

	@Override
	public List<Oferta> getOfertasGerador(Gerador gerador) {
		return ofertaDAO.obterOfertasGerador(gerador.getId());
	}
	
	public List<Oferta> obterListaOfertasDisponiveis() {
		return ofertaDAO.obterListaOfertasDisponiveis();
	}
	
	public Oferta retornarOferta(Long idOferta) {
		return ofertaDAO.retrieveById(idOferta);
	}

	@Override
	public String jsonOfertasEnderecos() {
		List<Oferta> ofertas = ofertaDAO.obterListaOfertasDisponiveis();
		JsonArrayBuilder builder = Json.createArrayBuilder();
		for (Oferta o: ofertas){
			Endereco e = o.getGerador().getUsuario().getEndereco();
			String mat = o.getMaterial().getTipoMaterial();
			String qtd = o.getQtdeMaterial().toString();
			// String end = e.getEnderecoCompleto();
			String end;
			if (e == null) {
				// end = "Espírito Santo, Vitória, Fernando Ferrari";
				continue;
			} else {
				end = e.getEnderecoCompleto();
			}
			// System.out.println(e);
			
			JsonObject jsobject = Json.createObjectBuilder()
				.add("material", mat)
				.add("quantidade", qtd)
				.add("endereco", end)
				.build();
			
			System.out.println("\033[31m" + jsobject.toString());
			builder = builder.add(jsobject);
		}
		JsonArray array = builder.build();

		return array.toString();
	}

}