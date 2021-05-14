package br.ufes.informatica.recyclo.core.application;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.informatica.recyclo.core.domain.Agendamento;
import br.ufes.informatica.recyclo.core.domain.Coletor;
import br.ufes.informatica.recyclo.core.persistence.AgendamentoDAO;
import br.ufes.informatica.recyclo.core.persistence.OfertaDAO;

@Stateless
public class AgendamentoServiceBean implements AgendamentoService {
	
	private static final long serialVersionUID = 1L;

	@EJB
	private AgendamentoDAO agendamentoDAO;
	
	@EJB
	private OfertaDAO ofertaDAO;

	public Boolean realizarAgendamento(Agendamento agendamento) {
		agendamentoDAO.save(agendamento);
		ofertaDAO.save(agendamento.getOferta());
		return true;
	}

	@Override
	public List<Agendamento> getAgendamentosColetor(Coletor coletor) {
		return agendamentoDAO.obterAgendasColetor(coletor);
	}
	
	

}