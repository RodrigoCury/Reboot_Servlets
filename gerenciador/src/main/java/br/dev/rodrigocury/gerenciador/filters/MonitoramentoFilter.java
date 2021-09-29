package br.dev.rodrigocury.gerenciador.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class MonitoramentoFilter
 */
public class MonitoramentoFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.print("Monit - ");
		
		long tempoInicial = System.currentTimeMillis();
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String uri = req.getRequestURI();
		String queryString = req.getQueryString() != null ? req.getQueryString() : "";
		
		String finalURL = uri + "?" + queryString;
		
		String method = req.getMethod();
		
		
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println(String.format("%04d ms - %4s | %s ", (tempoFinal - tempoInicial) , method, finalURL));
	}

}
