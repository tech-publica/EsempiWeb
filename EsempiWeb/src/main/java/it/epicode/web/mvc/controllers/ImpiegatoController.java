package it.epicode.web.mvc.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.mvc.model.Impiegato;
import it.epicode.web.mvc.model.data.AbstractImpiegatoRepository;
import it.epicode.web.mvc.model.data.DataException;
import it.epicode.web.mvc.model.data.ImpiegatoRepository;

public class ImpiegatoController {
	
	private AbstractImpiegatoRepository repo;
	public ImpiegatoController(AbstractImpiegatoRepository repo) { // dependency injection. IGNORANCE IS BLISS...
		this.repo = repo;
	}
	
	public String inserisciImpiegato(HttpServletRequest request, HttpServletResponse response) throws DataException {
		
		String idString = request.getParameter("id");
		long id = Long.parseLong(idString);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String role = request.getParameter("role");
		
		Impiegato imp = new Impiegato(id, firstname, lastname, role);
		repo.inserisciImpiegato(imp);
		
		
		return "confermaInserimentoImpiegato.jsp";
	}
	
	public String listaImpiegati(HttpServletRequest request, HttpServletResponse response) throws DataException {
		List<Impiegato> result = repo.listaImpiegati();
		// inserisco nello scope request gli impiegati letti da DB con la chiave ALL_EMPLOYEES in modo che la JSP li possa ripescare
		request.setAttribute("ALL_EMPLOYEES", result);
		return "listaImpiegati.jsp";
	}

	public String caricaImpiegato(HttpServletRequest request, HttpServletResponse response) throws DataException {
		long id = Long.parseLong(request.getParameter("id"));
		Impiegato imp = repo.findById(id)
				.orElseThrow(() -> new DataException("impiegato con id "  + id + " inesistente", null));
		request.setAttribute("toUpdate", imp);
		System.out.println("inserito impiegato con chiave toUpdate");
		return "aggiungiImpiegato.jsp";
	}

	public String updateImpiegato(HttpServletRequest request, HttpServletResponse response) throws DataException {
		String idString = request.getParameter("id");
		long id = Long.parseLong(idString);
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String role = request.getParameter("role");
		
		Impiegato imp = new Impiegato(id, firstname, lastname, role);
		repo.updateImpiegato(imp);
		return "confermaInserimentoImpiegato.jsp";
	}

}
