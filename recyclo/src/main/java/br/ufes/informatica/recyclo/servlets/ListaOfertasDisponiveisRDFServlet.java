package br.ufes.informatica.recyclo.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.RDFS;

import br.ufes.informatica.recyclo.core.application.OfertaService;
import br.ufes.informatica.recyclo.core.domain.Oferta;

@WebServlet(urlPatterns = { "/dados/ofertas-disponiveis" })
public class ListaOfertasDisponiveisRDFServlet extends HttpServlet {
	
	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	
	@EJB
	private OfertaService ofertaService;
	
	private List<Oferta> listaOfertasDisponiveis;
	
	private Oferta oferta;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// Tipo de resposta.
		resp.setContentType("text/xml");
		
		// Busca uma ou todas as ofertas disponíveis.
		String idParam = req.getParameter("id");
		
		// Busca todas as ofertas disponíveis.
		if (idParam == null) {
			listaOfertasDisponiveis = ofertaService.obterListaOfertasDisponiveis();
		} else {
			// Busca uma determinada oferta disponível.
			Long idOferta = Long.parseLong(idParam);
			oferta = ofertaService.retornarOferta(idOferta);
			listaOfertasDisponiveis = new ArrayList<Oferta>();
			listaOfertasDisponiveis.add(oferta);
		}
		
		// Modelo do Jena.
		Model model = ModelFactory.createDefaultModel();
		
		// Namespaces.
		String myNS = "http://localhost:8080/recyclo/dados/ofertas-disponiveis/";
		String grNS = "http://purl.org/goodrelations/v1#";
		model.setNsPrefix("gr", grNS);
		
		// Classe do vocabulário (GoodRelations).
		Resource grOffering = ResourceFactory.createResource(grNS + "Offering");
		
		// Propriedades (predicados) do vocabulário (GoodRelations).
		Property gravailabilityStarts = ResourceFactory.createProperty(grNS + "availabilityStarts");
		Property gravailabilityEnds = ResourceFactory.createProperty(grNS + "availabilityEnds");
		
		// Produzir o modelo em memória.
		for (Oferta oferta : listaOfertasDisponiveis) {
			model.createResource(myNS + oferta.getId())
				 .addProperty(RDF.type, grOffering)
				 .addProperty(RDFS.label, "Oferta de " + oferta.getMaterial().getTipoMaterial() + " para reciclagem.")
				 .addProperty(RDFS.comment, "Oferta de " + oferta.getQtdeMaterial() + " kg de material reciclável do tipo " + oferta.getMaterial().getTipoMaterial() + " no sistema Recyclo.")
				 .addLiteral(gravailabilityStarts,ResourceFactory.createTypedLiteral(df.format(oferta.getHorarioInicial()), XSDDatatype.XSDdateTime))
				 .addLiteral(gravailabilityEnds,ResourceFactory.createTypedLiteral(df.format(oferta.getHorarioFinal()), XSDDatatype.XSDdateTime));
		}
		
		// Serializa e envia para o navegador.
		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	
	}
}
