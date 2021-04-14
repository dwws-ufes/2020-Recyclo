package br.ufes.informatica.recyclo.core.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.omnifaces.util.Faces;

import com.github.adminfaces.template.config.AdminConfig;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.recyclo.core.application.LoginService;
import br.ufes.informatica.recyclo.core.domain.Usuario;
import br.ufes.informatica.recyclo.core.security.LogonMB;
import br.ufes.informatica.recyclo.utils.CriptografiaSenha;
import br.ufes.informatica.recyclo.utils.Utils;

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
	
	@Inject
	private AdminConfig adminConfig;
	
	@Inject
	private LogonMB logonMB;
	
	public LoginController() {
		this.usuario = new Usuario();
	}

	/** TODO: generated by FrameWeb. Should be documented. 
	 * @throws NoSuchAlgorithmException 
	 * @throws IOException */
	public void efetuarLogin() throws NoSuchAlgorithmException, IOException {
		
		// Criptografa a senha.
    	String senhaCriptografada = CriptografiaSenha.encriptPassword(usuario.getSenha());
    	usuario.setSenha(senhaCriptografada);
    	
    	// Chama a classe de servico para verificar se o usuário está cadastrado.
    	Usuario usuarioLogado = loginService.efetuarLogin(usuario);
    	
    	// Se o usuário está cadastrado, redireciona para a página principal.
    	if (usuarioLogado != null) {
    		logonMB.setLogado(true);
    		logonMB.setCurrentUser(usuarioLogado.getNome());
    		logonMB.setUsuario(usuarioLogado);
			logonMB.setEmail(usuarioLogado.getEmail());
    		if (usuarioLogado.getPermissao().equals("Coletor")) {
    			logonMB.setUsuarioColetor(true);
    			logonMB.setColetor(usuarioLogado.getColetor());
    		}
    		if (usuarioLogado.getPermissao().equals("Gerador")) {
    			logonMB.setUsuarioGerador(true);
    			logonMB.setGerador(usuarioLogado.getGerador());
    		}
	        Utils.addDetailMessage("Login efetuado com sucesso como <b>" + usuarioLogado.getEmail() + "</b>");
	        Faces.getExternalContext().getFlash().setKeepMessages(true);
	        Faces.redirect(adminConfig.getIndexPage());
    	} else {
    		// Se o usuário não está cadastrado, permanece na página de login e apresenta mensagem de erro.
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail e/ou senha incorreto(s)", "E-mail e/ou senha incorreto(s)"));
    	}
		
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