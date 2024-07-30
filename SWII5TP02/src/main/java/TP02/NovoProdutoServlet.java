//Mariana Costa da Luz
package TP02;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novoProduto")
public class NovoProdutoServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando Novo Produto");
		
		String nomeProduto = request.getParameter("nome");
		String paramDescricaoProduto = request.getParameter("descricao");		
		String paramUnidade = request.getParameter("unidade");
		String paramQtdPrevistaMes = request.getParameter("qtdPrevistoMes");
		String paramPrecoMaxComprado = request.getParameter("precoMaxComprado");
			
		Integer unidadeCompra = Integer.valueOf(paramUnidade);
		Double qtdPrevistoMes = Double.valueOf(paramQtdPrevistaMes);
		Double precoMaxComprado = Double.valueOf(paramPrecoMaxComprado);
		
		Produto produto = new Produto();
		produto.setNome(nomeProduto);
		produto.setDescricao(paramDescricaoProduto);
		produto.setUnidadeCompra(unidadeCompra);
		produto.setQtdPrevistoMes(qtdPrevistoMes);
		produto.setPrecoMaxComprado(precoMaxComprado);
		
		Banco banco = new Banco();
		banco.adicionaProduto(produto);
		
		request.setAttribute("produto", produto.getNome());
		
		response.sendRedirect("novoProdutoCriado");
	}	
}
