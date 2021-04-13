package br.ufes.informatica.recyclo.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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

    @EJB
    private OfertaController ofertaController;

    @PostConstruct
    public void init() {
        Usuario usuario = logonMB.getUsuario();
        Collection ofertas_col = ofertaController.getOfertasGerador(usuario);
        ofertas = new ArrayList();
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

}
