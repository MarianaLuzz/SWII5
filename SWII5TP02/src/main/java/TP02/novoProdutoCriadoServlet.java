package TP02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novoProdutoCriado")
public class novoProdutoCriadoServlet extends HttpServlet{
private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Banco banco = new Banco();
		List<Produto> lista = banco.getProdutos();
		
		request.setAttribute("produtos", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("/novoProdutoCriado.jsp");
		rd.forward(request, response);
	}	

}
