package br.dev.rodrigocury.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.dev.rodrigocury.gerenciador.acao.Acao;

/**
 * Servlet Filter implementation class autorização
 */
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.print("Ctrl - ");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String acaoParam = req.getParameter("acao") != null ? req.getParameter("acao") : "";
		
		String actionResponse = null;
		
		try {
			Class<?> classe = Class.forName("br.dev.rodrigocury.gerenciador.acao."+acaoParam);
			Acao obj = (Acao) classe.getDeclaredConstructor().newInstance();
			actionResponse = obj.executa(req, res);
		} catch (Exception e) {
			System.out.println(acaoParam);
			actionResponse = "error:404";
		}		

		String[] respELocalizacao = actionResponse.split(":");

		String action = respELocalizacao[0];
		String command = respELocalizacao[1];

		switch (action) {
		case "forward":
			RequestDispatcher rd = req.getRequestDispatcher(command);
			rd.forward(req, res);
			break;
		case "redirect":
			res.sendRedirect(command);
			break;
		case "error":
			res.sendError(Integer.parseInt(command));
			break;
		default:
			// Fazer LOG de erros
			System.out.println("Erro Interno");
			System.out.println(acaoParam + "  " + action + " " + command);
			res.sendError(500);
		}
		
	}

}
