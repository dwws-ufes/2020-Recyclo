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
import br.ufes.informatica.recyclo.core.application.ColetorService;
import br.ufes.informatica.recyclo.core.domain.Coletor;
import br.ufes.informatica.recyclo.core.domain.Endereco;
import br.ufes.informatica.recyclo.core.domain.Municipio;
import br.ufes.informatica.recyclo.core.domain.TipoPessoa;
import br.ufes.informatica.recyclo.core.domain.Usuario;
import br.ufes.informatica.recyclo.core.security.LogonMB;
import br.ufes.informatica.recyclo.utils.CriptografiaSenha;
import br.ufes.informatica.recyclo.utils.Utils;

/** TODO: generated by FrameWeb. Should be documented. */
@Model
public class ColetorController extends JSFController {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. */
	@EJB
	private ColetorService coletorService;
	
	@Inject
	private AdminConfig adminConfig;
	
	@Inject
	private LogonMB logonMB;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Coletor coletor;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Endereco endereco;

	/** TODO: generated by FrameWeb. Should be documented. */
	private Municipio municipio;

	/** TODO: generated by FrameWeb. Should be documented. */
	private String repeteSenha;
	
	private String documento;
	
	public ColetorController() {
		Usuario usuario = new Usuario();
		coletor = new Coletor();
		coletor.setUsuario(usuario);
	}
	
	/** TODO: generated by FrameWeb. Should be documented. 
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException */
	public void incluirColetor() throws IOException, NoSuchAlgorithmException {
		
		// Chama o método da classe de servico para incluir o coletor.
		coletor.getUsuario().setPermissao("Coletor");
		coletor.getUsuario().setDataCadastro(new java.util.Date());
		if (coletor.getUsuario().getTipoPessoa().equals(TipoPessoa.Fisica)) {
			coletor.setCpf(documento);
		}
		if (coletor.getUsuario().getTipoPessoa().equals(TipoPessoa.Juridica)) {
			coletor.setCnpj(documento);
		}
		String senhaCriptografada = CriptografiaSenha.encriptPassword(coletor.getUsuario().getSenha());
		coletor.getUsuario().setSenha(senhaCriptografada);
		boolean coletorCadastrado = coletorService.incluirColetor(coletor);
		
		// Se o coletor foi cadastrado, redireciona para a página inicial.
		if (coletorCadastrado == true) {
			logonMB.setCurrentUser(coletor.getUsuario().getNome());
			logonMB.setUsuarioColetor(true);
			logonMB.setUsuario(coletor.getUsuario());
			logonMB.setColetor(coletor);
			Utils.addDetailMessage("Cadastro realizado com sucesso! Comece a reciclar agora mesmo!");
	        Faces.getExternalContext().getFlash().setKeepMessages(true);
	        Faces.redirect(adminConfig.getIndexPage());
		} else {
			// Se o coletor não foi cadastrado porque o e-mail informado já estava cadastrado, retorna mensagem de erro.
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "O e-mail informado já foi cadastrado.", "O e-mail informado já foi cadastrado."));
		}
		
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	public void alterarColetor(Usuario usuario) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro atualizado com sucesso!" + usuario.getEmail(), "Cadastro atualizado com sucesso!" + usuario.getEmail()));
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	public String excluirColetor() {
		// FIXME: auto-generated method stub
		return null;
	}

	/** TODO: generated by FrameWeb. Should be documented. */
	public String consultarColetor() {
		// FIXME: auto-generated method stub
		return null;
	}

	/** Getter for coletor. */
	public Coletor getColetor() {
		return coletor;
	}

	/** Setter for coletor. */
	public void setColetor(Coletor coletor) {
		this.coletor = coletor;
	}

	/** Getter for endereco. */
	public Endereco getEndereco() {
		return endereco;
	}

	/** Setter for endereco. */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/** Getter for municipio. */
	public Municipio getMunicipio() {
		return municipio;
	}

	/** Setter for municipio. */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/** Getter for repeteSenha. */
	public String getRepeteSenha() {
		return repeteSenha;
	}

	/** Setter for repeteSenha. */
	public void setRepeteSenha(String repeteSenha) {
		this.repeteSenha = repeteSenha;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}