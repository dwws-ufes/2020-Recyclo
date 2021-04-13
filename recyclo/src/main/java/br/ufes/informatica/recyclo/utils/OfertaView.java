package br.ufes.informatica.recyclo.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.informatica.recyclo.core.application.OfertaService;
import br.ufes.informatica.recyclo.core.controller.OfertaController;
import br.ufes.informatica.recyclo.core.domain.Gerador;
import br.ufes.informatica.recyclo.core.domain.Oferta;
import br.ufes.informatica.recyclo.core.domain.Usuario;
import br.ufes.informatica.recyclo.core.security.LogonMB;

@Named("dtOfertaView")
@ViewScoped
public class OfertaView implements Serializable{
    
    private List<Oferta> ofertas;

    @Inject
	private LogonMB logonMB;

    private OfertaController ofertaController;

    // OfertaDAOJPA service;
    // LoginController login;

    @PostConstruct
    public void init() {
        Usuario usuario = logonMB.getUsuario();
        OfertaService oferta_c = ofertaController.getService();
        System.out.println("Services funcionou");
        Collection ofertas_col = oferta_c.getOfertasGerador(usuario);
        System.out.println(ofertas_col);
        // ofertas = new ArrayList(ofertas_col);
        ofertas = new ArrayList();
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

}
