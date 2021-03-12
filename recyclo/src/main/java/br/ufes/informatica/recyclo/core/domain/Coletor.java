package br.ufes.informatica.recyclo.core.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

/** TODO: generated by FrameWeb. Should be documented. */
@Entity
public class Coletor extends PersistentObjectSupport implements Comparable<Coletor> {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@NotNull
	private MeioDeColeta meioDeColeta;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@Size(max = 11)
	private String cpf;

	/** TODO: generated by FrameWeb. Should be documented. false */
	@Size(max = 14)
	private String cnpj;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany
	private Set<Municipio> Target;

	/** TODO: generated by FrameWeb. Should be documented. */
	@OneToMany(mappedBy = "Source")
	private Set<Agendamento> Target;

	/** TODO: generated by FrameWeb. Should be documented. */
	@ManyToMany(mappedBy = "Target")
	private Set<Material> Source;

	/** Getter for meioDeColeta. */
	public MeioDeColeta getMeioDeColeta() {
		return meioDeColeta;
	}

	/** Setter for meioDeColeta. */
	public void setMeioDeColeta(MeioDeColeta meioDeColeta) {
		this.meioDeColeta = meioDeColeta;
	}

	/** Getter for cpf. */
	public String getCpf() {
		return cpf;
	}

	/** Setter for cpf. */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/** Getter for cnpj. */
	public String getCnpj() {
		return cnpj;
	}

	/** Setter for cnpj. */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/** Getter for Target. */
	public Set<Municipio> getTarget() {
		return Target;
	}

	/** Setter for Target. */
	public void setTarget(Set<Municipio> Target) {
		this.Target = Target;
	}

	/** Getter for Target. */
	public Set<Agendamento> getTarget() {
		return Target;
	}

	/** Setter for Target. */
	public void setTarget(Set<Agendamento> Target) {
		this.Target = Target;
	}

	/** Getter for Source. */
	public Set<Material> getSource() {
		return Source;
	}

	/** Setter for Source. */
	public void setSource(Set<Material> Source) {
		this.Source = Source;
	}

	/** @see java.lang.Comparable#compareTo(java.lang.Object) */
	@Override
	public int compareTo(Coletor o) {
		// FIXME: auto-generated method stub
		return super.compareTo(o);
	}
}