package br.ufes.informatica.recyclo.core.application;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.ufes.informatica.recyclo.core.domain.Material;

@Local
public interface MaterialService extends Serializable {

	public List<Material>  obterListaMateriais();

}