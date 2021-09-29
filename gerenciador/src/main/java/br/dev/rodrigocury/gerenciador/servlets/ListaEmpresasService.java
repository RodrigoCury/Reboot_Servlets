package br.dev.rodrigocury.gerenciador.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.dev.rodrigocury.gerenciador.models.Banco;
import br.dev.rodrigocury.gerenciador.models.Empresa;

/**
 * Servlet implementation class ListaEmpresasService
 */
@WebServlet("/empresas")
public class ListaEmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaEmpresasService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> empresas = new ArrayList<Empresa>(Banco.getEmpresas());
		
		String toResponse;
		String cType = request.getHeader("accept") != null ? request.getHeader("accept") : " ";
		
		switch (cType) {
		case "application/xml":
			XStream xstream = new XStream();
			xstream.alias("listaEmpresas", List.class);
			xstream.alias("empresa", Empresa.class);
			toResponse = xstream.toXML(empresas);
			response.setContentType(cType);
			break;
		case "application/json":
			Gson gson = new Gson();
			toResponse = gson.toJson(empresas);
			response.setContentType(cType);
			break;		
		default:
			response.sendError(415, "Apenas é aceito application/xml ou application/json");
			return;
		}
		
		response.getWriter().print(toResponse);				
	}

}
