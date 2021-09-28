package br.dev.rodrigocury.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.models.Banco;

public class ListaEmpresas {
	
	public static void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("empresas", Banco.getEmpresas());
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");
		rd.forward(request, response);
	}
}
