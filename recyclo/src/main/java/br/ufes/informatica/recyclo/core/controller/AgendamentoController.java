package br.ufes.informatica.recyclo.core.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.omnifaces.util.Faces;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.recyclo.core.application.AgendamentoService;
import br.ufes.informatica.recyclo.core.domain.Agendamento;
import br.ufes.informatica.recyclo.core.domain.Coletor;
import br.ufes.informatica.recyclo.core.security.LogonMB;
import br.ufes.informatica.recyclo.utils.Utils;

/** TODO: generated by FrameWeb. Should be documented. */
@Model
public class AgendamentoController extends JSFController {
	/** Serialization id (using default value, change if necessary). */
	private static final long serialVersionUID = 1L;

	@EJB
	private AgendamentoService agendamentoService;
	
	@Inject
	private LogonMB logonMB;
	
	private Coletor coletor;
	
	private Agendamento agendamento;
	
	private List<Agendamento> agendamentosColetor;
	
	public AgendamentoController() {
		this.agendamento = new Agendamento();
	}
	
	@PostConstruct
	public void init() {
		coletor = logonMB.getColetor();
	}

	public void realizarAgendamento() throws IOException {
		agendamento.setColetor(coletor);
		agendamento.setGerador(agendamento.getOferta().getGerador());
		agendamento.getOferta().setColetado(true);
		boolean agendamentoRealizado = agendamentoService.realizarAgendamento(agendamento);

		if (agendamentoRealizado == true) {
			Utils.addDetailMessage("Agendamento de coleta de material realizado com sucesso! Você está colaborando para um mundo mais sustentável!");
	        Faces.getExternalContext().getFlash().setKeepMessages(true);
	        Faces.redirect("/recyclo/core/oferta/meus-agendamentos.xhtml");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro desconhecido.", "Erro desconhecido."));
		}
	}

	public List<Agendamento> getAgendamentosColetor() {
		return agendamentoService.getAgendamentosColetor(logonMB.getColetor());
	}

	public void setAgendamentosColetor(List<Agendamento> agendamentosColetor) {
		this.agendamentosColetor = agendamentosColetor;
	}

	public Agendamento getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(Agendamento agendamento) {
		this.agendamento = agendamento;
	}

}