package br.ufes.informatica.recyclo.core.security;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Specializes;
import javax.inject.Named;

import com.github.adminfaces.template.session.AdminSession;

import br.ufes.informatica.recyclo.core.domain.Coletor;
import br.ufes.informatica.recyclo.core.domain.Gerador;
import br.ufes.informatica.recyclo.core.domain.Usuario;

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
    private boolean logado = false;
    private String email;
    private String password;
    private boolean remember;
    private boolean usuarioColetor = false;
    private boolean usuarioGerador = false;
    private Usuario usuario;
    private Coletor coletor;
    private Gerador gerador;
  

    @Override
    public boolean isLoggedIn() {

        return this.logado;
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

	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public boolean isUsuarioColetor() {
		return usuarioColetor;
	}

	public void setUsuarioColetor(boolean usuarioColetor) {
		this.usuarioColetor = usuarioColetor;
	}

	public boolean isUsuarioGerador() {
		return usuarioGerador;
	}

	public void setUsuarioGerador(boolean usuarioGerador) {
		this.usuarioGerador = usuarioGerador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Coletor getColetor() {
		return coletor;
	}

	public void setColetor(Coletor coletor) {
		this.coletor = coletor;
	}

	public Gerador getGerador() {
		return gerador;
	}

	public void setGerador(Gerador gerador) {
		this.gerador = gerador;
	}

}