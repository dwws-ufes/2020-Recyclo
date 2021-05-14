package br.ufes.informatica.recyclo.core.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.informatica.recyclo.core.domain.Material;
import br.ufes.informatica.recyclo.core.persistence.MaterialDAO;

@Stateless
public class MaterialServiceBean implements MaterialService {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private MaterialDAO materialDAO;

	public List<Material> obterListaMateriais() {
		return materialDAO.retrieveAll();
	}

}