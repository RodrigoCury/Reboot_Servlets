package br.dev.rodrigocury.gerenciador.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class autorizaÁ„o
 */
public class AutorizacaoFilter implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.print("Auth - ");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String acaoParam = req.getParameter("acao");
		
		boolean usuarioNaoEst·Logado = (req.getSession().getAttribute("usuarioLogado") == null);
		boolean ehUmaAcaoProtegida = !acaoParam.equals("Login");
		
		if (ehUmaAcaoProtegida & usuarioNaoEst·Logado) {
			res.sendRedirect("entrada?acao=Login");
			return;
		}
			
		chain.doFilter(req, res);
	}

}
