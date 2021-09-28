package br.dev.rodrigocury.gerenciador.servlets;

import java.io.IOException;
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
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acaoParam = request.getParameter("acao");
		
		switch (acaoParam) {
			case "ListaEmpresas":
				ListaEmpresas.executa(request, response);
				break;
			case "MostraEmpresa":
				MostraEmpresa.executa(request, response);
				break;
			case "RemoveEmpresa":
				RemoveEmpresa.executa(request, response);
				break;
			case "NovaEmpresa":
				NovaEmpresa.executa(request, response);
				break;
			default:
				response.sendError(404);
		}
	}

}
