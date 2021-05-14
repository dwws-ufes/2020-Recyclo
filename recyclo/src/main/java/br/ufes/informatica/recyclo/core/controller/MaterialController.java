package br.ufes.informatica.recyclo.core.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.recyclo.core.application.MaterialService;
import br.ufes.informatica.recyclo.core.domain.Material;

@Model
public class MaterialController extends JSFController {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private MaterialService materialService;
	
	private List<Material> listaMateriais;
	
	public MaterialController() {
		
	}
	
	@PostConstruct
	public void init() {
		this.listaMateriais = materialService.obterListaMateriais();
	}
	
	public List<Material> obterListaMateriais(){
		return this.listaMateriais;
	}

	public MaterialService getMaterialService() {
		return materialService;
	}

	public void setMaterialService(MaterialService materialService) {
		this.materialService = materialService;
	}

	public List<Material> getListaMateriais() {
		return listaMateriais;
	}

	public void setListaMateriais(List<Material> listaMateriais) {
		this.listaMateriais = listaMateriais;
	}

}