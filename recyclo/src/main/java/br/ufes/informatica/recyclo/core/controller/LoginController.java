package br.ufes.informatica.recyclo.core.controller;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.recyclo.core.application.LoginService;
import br.ufes.informatica.recyclo.core.domain.Usuario;

/** TODO: generated by FrameWeb. Should be documented. */
@Model
public class LoginController extends JSFController {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private LoginService loginService;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Usuario usuario;

	/** TODO: generated by FrameWeb. Should be documented. */
	public String efetuarLogin() {
		// FIXME: auto-generated method stub
		return null;
	}

	/** Getter for usuario. */
	public Usuario getUsuario() {
		return usuario;
	}

	/** Setter for usuario. */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}