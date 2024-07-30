//Mariana Costa da Luz
package TP02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mostraProduto")
public class MostraProdutoServlet extends HttpServlet {

private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		Banco banco = new Banco();
		
		Produto produto = banco.buscaProdutoPeloId(id);
		
		System.out.println(produto.getNome());
		
		request.setAttribute("produto", produto);
		
		RequestDispatcher rd = request.getRequestDispatcher("/formAlteraProduto.jsp");
		rd.forward(request, response);
	}		
}
