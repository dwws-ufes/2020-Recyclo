package br.ufes.informatica.recyclo.core.controller;

import java.io.IOException;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.omnifaces.util.Faces;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.recyclo.core.security.LogonMB;

@Model
public class CadastroController extends JSFController {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private LogonMB logonMB;
	
	public CadastroController() {
		
	}

	public void cadastro() throws IOException {
		logonMB.setLogado(true);
    	Faces.getExternalContext().getFlash().setKeepMessages(true);
    	Faces.redirect("/recyclo/core/cadastro/incluir-usuario.xhtml");
    }

}