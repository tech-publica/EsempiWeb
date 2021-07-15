package it.epicode.web.mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.epicode.web.mvc.controllers.BaseController;
import it.epicode.web.mvc.controllers.ImpiegatoController;
import it.epicode.web.mvc.model.data.DataException;
import it.epicode.web.mvc.model.data.ImpiegatoRepository;

@WebServlet("*.do") // url mapping
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String path = request.getRequestURI();
		int slash = path.lastIndexOf('/');
		String action = path.substring(slash + 1, path.length() - 3);
		String destination = "";
		try {

			switch (action.toLowerCase()) {
			case "inserisciimpiegato": {
				ImpiegatoController controller = new ImpiegatoController(new ImpiegatoRepository());
				destination = controller.inserisciImpiegato(request, response);
			}
				break;
			case "updateimpiegato": {
				ImpiegatoController controller = new ImpiegatoController(new ImpiegatoRepository());
				destination = controller.updateImpiegato(request, response);
			}
				break;
			case "listaimpiegati": {
				ImpiegatoController controller = new ImpiegatoController(new ImpiegatoRepository());
				destination = controller.listaImpiegati(request, response);
			}
				break;
			case "mostraformaggiuntaimpiegato": {		
				destination = "aggiungiImpiegato.jsp";
			}
				break;
			case "mostraformupdateimpiegato": {		
				ImpiegatoController controller = new ImpiegatoController(new ImpiegatoRepository());
				
				destination = controller.caricaImpiegato(request, response);
			}
				break;
			default: {
				BaseController controller = new BaseController();
				destination = controller.showErrorPageForMissingUrl(request, response);
			}

			}
		} catch (DataException de) {
			request.setAttribute("EXCEPTION", de);
			destination = "dataConnectionError.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(destination);
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
