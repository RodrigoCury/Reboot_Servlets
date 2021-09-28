package br.dev.rodrigocury.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;
import br.dev.rodrigocury.gerenciador.models.Empresa;

/**
 * Servlet implementation class MostraEmpresaServlet
 */
//@WebServlet("/mostraEmpresa")
public class MostraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostraEmpresaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Empresa empresa = Banco.getEmpresa(idInt);
		if (empresa == null) {
			response.sendRedirect("listaEmpresas");
			return;
		}
		
		request.setAttribute("empresa", empresa);
		
		RequestDispatcher rd = request.getRequestDispatcher("/alteraEmpresa.jsp");
		
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeAlterado = request.getParameter("nome");
		String id = (String) request.getParameter("id");
		Integer idInt = Integer.valueOf(id);
		
		Empresa empresa = Banco.getEmpresa(idInt);
		if (empresa == null | nomeAlterado == "") {
			response.sendRedirect("listaEmpresas");
			return;
		}
		empresa.setNome(nomeAlterado);
		
		response.sendRedirect("listaEmpresas");
	}

}
