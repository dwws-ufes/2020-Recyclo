package br.ufes.informatica.recyclo.core.application;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import br.ufes.informatica.recyclo.core.domain.Agendamento;
import br.ufes.informatica.recyclo.core.domain.Coletor;

@Local
public interface AgendamentoService extends Serializable {

	public Boolean realizarAgendamento(Agendamento agendamento);
	
	public List<Agendamento> getAgendamentosColetor(Coletor coletor);

}