package br.ufes.informatica.recyclo.utils;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

@Named
@ViewScoped
public class SaibaMaisView implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String definicaoResiduoSolido;
	private String definicaoReciclagem;
	private String definicaoPapel;
	private String definicaoPlastico;
	private String definicaoVidro;
	private String definicaoMetal;

    @PostConstruct
	public void init() {
    	this.definicaoResiduoSolido = this.realizaConsultaSPARQL("Waste");
    	this.definicaoReciclagem = this.realizaConsultaSPARQL("Recycling");
    	this.definicaoPapel = this.realizaConsultaSPARQL("Paper");
    	this.definicaoPlastico = this.realizaConsultaSPARQL("Plastic");
    	this.definicaoVidro = this.realizaConsultaSPARQL("Glass");
    	this.definicaoMetal = this.realizaConsultaSPARQL("Metal");
	}
    
    // Realiza uma consulta SPARQL.
    public String realizaConsultaSPARQL(String nomeRecurso) {
    	
    	// Define a consulta SPARQL.
    	String query = 
    	"PREFIX dbo: <http://dbpedia.org/ontology/>\n" +
    	"PREFIX dbr: <http://dbpedia.org/resource/>\n" +
    	"PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
    	"SELECT ?Comment\n" +
    	"WHERE {\n" +
    	" dbr:" + nomeRecurso + " rdfs:comment ?Comment.\n" +
    	" FILTER langMatches(lang(?Comment),'pt')\n" +
    	"}";
    	
    	// Executa a consulta SPARQL.
    	QueryExecution queryExecution = QueryExecutionFactory.sparqlService("https://dbpedia.org/sparql", query);
    	
    	// Obtém o resultado da consulta SPARQL.
    	ResultSet result = queryExecution.execSelect();
    	QuerySolution querySolution = result.next();
    	org.apache.jena.rdf.model.Literal literal = querySolution.getLiteral("Comment");
    	
    	// Retorna o resultado da consulta SPARQL.
    	return (String) literal.getValue();
    
    }

	public String getDefinicaoResiduoSolido() {
		return definicaoResiduoSolido;
	}

	public void setDefinicaoResiduoSolido(String definicaoResiduoSolido) {
		this.definicaoResiduoSolido = definicaoResiduoSolido;
	}

	public String getDefinicaoReciclagem() {
		return definicaoReciclagem;
	}

	public void setDefinicaoReciclagem(String definicaoReciclagem) {
		this.definicaoReciclagem = definicaoReciclagem;
	}

	public String getDefinicaoPapel() {
		return definicaoPapel;
	}

	public void setDefinicaoPapel(String definicaoPapel) {
		this.definicaoPapel = definicaoPapel;
	}

	public String getDefinicaoPlastico() {
		return definicaoPlastico;
	}

	public void setDefinicaoPlastico(String definicaoPlastico) {
		this.definicaoPlastico = definicaoPlastico;
	}

	public String getDefinicaoVidro() {
		return definicaoVidro;
	}

	public void setDefinicaoVidro(String definicaoVidro) {
		this.definicaoVidro = definicaoVidro;
	}

	public String getDefinicaoMetal() {
		return definicaoMetal;
	}

	public void setDefinicaoMetal(String definicaoMetal) {
		this.definicaoMetal = definicaoMetal;
	}
	
}