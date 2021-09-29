package br.dev.rodrigocury.gerenciador.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acaoParam = request.getParameter("acao") != null ? request.getParameter("acao") : "";
				
		boolean usuarioNaoEst·Logado = (request.getSession().getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !acaoParam.equals("Login");
		
		if (ehUmaAcaoProtegida & usuarioNaoEst·Logado) {
			response.sendRedirect("entrada?acao=Login");
			return;
		}
			

		String actionResponse = null;
		
		try {
			Class<?> classe = Class.forName("br.dev.rodrigocury.gerenciador.acao."+acaoParam);
			Acao obj = (Acao) classe.getDeclaredConstructor().newInstance();
			actionResponse = obj.executa(request, response);
		} catch (Exception e) {
			System.out.println(acaoParam);
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
			System.out.println(acaoParam + "  " + action + " " + command);
			response.sendError(500);

		}

	}

}
