package br.dev.rodrigocury.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.acao.ListaEmpresas;
import br.dev.rodrigocury.gerenciador.acao.MostraEmpresa;
import br.dev.rodrigocury.gerenciador.acao.NovaEmpresa;
import br.dev.rodrigocury.gerenciador.acao.RemoveEmpresa;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UnicaEntradaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acaoParam = request.getParameter("acao") != null ? request.getParameter("acao") : "";

		String actionResponse = null;
		switch (acaoParam) {
		case "ListaEmpresas":
			actionResponse = ListaEmpresas.executa(request, response);
			break;
		case "MostraEmpresa":
			actionResponse = MostraEmpresa.executa(request, response);
			break;
		case "RemoveEmpresa":
			actionResponse = RemoveEmpresa.executa(request, response);
			break;
		case "NovaEmpresa":
			actionResponse = NovaEmpresa.executa(request, response);
			break;
		default:
			System.out.println("HERE");
			actionResponse = "error:404";
		}

		String[] respELocalizacao = actionResponse.split(":");

		String action = respELocalizacao[0];
		String command = respELocalizacao[1];

		switch (action) {
		case "forward":
			RequestDispatcher rd = request.getRequestDispatcher(command);
			rd.forward(request, response);
			break;
		case "redirect":
			response.sendRedirect(command);
			break;
		case "error":
			response.sendError(Integer.parseInt(command));
			break;
		default:
			// Fazer LOG de erros
			System.out.println("Erro Interno");
			System.out.println(action + " " + command);
			response.sendError(500);

		}

	}

}
