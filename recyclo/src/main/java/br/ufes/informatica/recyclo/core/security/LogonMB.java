package br.ufes.informatica.recyclo.core.security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Faces;

import com.github.adminfaces.template.config.AdminConfig;
import com.github.adminfaces.template.session.AdminSession;

import br.ufes.informatica.recyclo.core.application.LoginService;
import br.ufes.informatica.recyclo.core.domain.Usuario;
import br.ufes.informatica.recyclo.utils.Utils;

/**
 * Created by rmpestano on 12/20/14.
 *
 * This is just a login example.
 *
 * AdminSession uses isLoggedIn to determine if user must be redirect to login page or not.
 * By default AdminSession isLoggedIn always resolves to true so it will not try to redirect user.
 *
 * If you already have your authorization mechanism which controls when user must be redirect to initial page or logon
 * you can skip this class.
 */
@Named
@SessionScoped
@Specializes
public class LogonMB extends AdminSession implements Serializable {

    private String currentUser;
    private String email;
    private String password;
    private boolean remember;
    private String currentUserName;
    @Inject
    private AdminConfig adminConfig;
    @Inject
    private Utils utils;
    @Inject
    LoginService loginService;


    public void login() throws IOException {
    	
    	// Inicializa um objeto da classe "Usuario".
    	Usuario usuario = new Usuario();
    	usuario.setEmail(this.email);
    	usuario.setSenha(this.password);
    	
    	// Chama a classe de servico para verificar se o usuário está cadastrado.
    	Usuario usuarioLogado = loginService.efetuarLogin(usuario);
    	
    	// Se o usuário está cadastrado, redireciona para a página principal.
    	if (usuarioLogado != null) {
	        currentUser = email;
            currentUserName = usuarioLogado.getNome();
	        utils.addDetailMessage("Login efetuado com sucesso como <b>" + usuario.getEmail() + "</b>");
	        Faces.getExternalContext().getFlash().setKeepMessages(true);
	        Faces.redirect(adminConfig.getIndexPage());
    	} else {
    		// Se o usuário não está cadastrado, permanece na página de login e apresenta mensagem de erro.
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "E-mail e/ou senha incorreto(s)", "E-mail e/ou senha incorreto(s)"));
    	}
    }

    @Override
    public boolean isLoggedIn() {

        return currentUser != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRemember() {
        return remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
    }

    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getCurrentUserName() {
        return currentUserName;
    }

    public void setCurrentUserName(String currentUserName) {
        this.currentUserName = currentUserName;
    }
}