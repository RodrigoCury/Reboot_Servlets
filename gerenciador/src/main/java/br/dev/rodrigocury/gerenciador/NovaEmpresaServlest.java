package br.dev.rodrigocury.gerenciador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NovaEmpresaServlest
 */
@WebServlet(urlPatterns = "/novaEmpresa")
public class NovaEmpresaServlest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("name");
		
		System.out.println("Cadastrando Nova empresa: "+ nome);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("Empresa Cadastrada!");
		out.println("</html></body>");
	}

}
