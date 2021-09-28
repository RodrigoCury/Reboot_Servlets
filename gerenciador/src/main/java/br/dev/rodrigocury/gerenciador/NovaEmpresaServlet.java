package br.dev.rodrigocury.gerenciador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.models.Banco;
import br.dev.rodrigocury.models.Empresa;

/**
 * Servlet implementation class NovaEmpresaServlest
 */
@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try{	
			Empresa novaEmpresa = new Empresa(request.getParameter("nome"));

			Banco.add(novaEmpresa);
			
			request.setAttribute("empresa", novaEmpresa);
		} catch (Exception e) {
			e.getStackTrace();
			request.setAttribute("error", true);
			
		} finally {
//			
//			RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//			rd.forward(request, response);
			
			response.sendRedirect("listaEmpresas");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.sendRedirect("novaEmpresa.jsp");
	}

}
