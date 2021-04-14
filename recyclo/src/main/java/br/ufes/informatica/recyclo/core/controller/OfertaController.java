package br.ufes.informatica.recyclo.core.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.omnifaces.util.Faces;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.recyclo.core.application.OfertaService;
import br.ufes.informatica.recyclo.core.domain.Endereco;
import br.ufes.informatica.recyclo.core.domain.Gerador;
import br.ufes.informatica.recyclo.core.domain.Material;
import br.ufes.informatica.recyclo.core.domain.Oferta;
import br.ufes.informatica.recyclo.core.domain.Usuario;
import br.ufes.informatica.recyclo.core.security.LogonMB;
import br.ufes.informatica.recyclo.utils.Utils;

/** TODO: generated by FrameWeb. Should be documented. */
@Model
public class OfertaController extends JSFController {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private OfertaService ofertaService;

	@Inject
	private LogonMB logonMB;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Gerador gerador;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Oferta oferta;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Material material;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Endereco endereco;

	private List<Oferta> ofertasGerador;

	public OfertaController(){
		oferta = new Oferta();
		material = new Material();
	}

	@PostConstruct
	public void init() {
		gerador = logonMB.getGerador();
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	public void incluirOferta() throws IOException, NoSuchAlgorithmException{
		oferta.setGerador(gerador);
		boolean ofertaCadastrada = ofertaService.incluirOferta(oferta);

		if (ofertaCadastrada == true) {
			Utils.addDetailMessage("Oferta cadastrada com sucesso! Você está colaborando para um mundo mais sustentável!");
	        Faces.getExternalContext().getFlash().setKeepMessages(true);
	        Faces.redirect("/recyclo/core/oferta/minhas-ofertas.xhtml");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro desconhecido.", "Erro desconhecido."));
		}
	}
	
	/** Getter for service. */
	public OfertaService getService() {
		return ofertaService;
	}
	
	public List<Oferta> getOfertasGerador(){
		Collection col = ofertaService.getOfertasGerador(logonMB.getUsuario());
		ofertasGerador = new ArrayList(col);
		return ofertasGerador;
	}

	/** Getter for gerador. */
	public Gerador getGerador() {
		return gerador;
	}

	/** Setter for gerador. */
	public void setGerador(Gerador gerador) {
		this.gerador = gerador;
	}

	/** Getter for oferta. */
	public Oferta getOferta() {
		return oferta;
	}

	/** Setter for oferta. */
	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	/** Getter for material. */
	public Material getMaterial() {
		return material;
	}

	/** Setter for material. */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/** Getter for endereco. */
	public Endereco getEndereco() {
		return endereco;
	}

	/** Setter for endereco. */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}