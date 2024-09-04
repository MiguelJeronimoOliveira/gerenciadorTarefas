package br.com.filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jpautil.JPAUtil;


@WebFilter(urlPatterns = {"*.jsf"})
public class FiltroAutenticacao implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        JPAUtil.getEntityManager();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        
        Object usuarioLogado = (session != null) ? session.getAttribute("usuarioLogado") : null;

        
        String url = req.getRequestURI();

        // Verifica a URL
        if (usuarioLogado == null && !url.endsWith("index.jsf") && !url.contains("javax.faces.resource")) {
            // Redireciona pro login
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsf");
            dispatcher.forward(request, response);
        } else {
           
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        
    }
}
