//Mariana Costa da Luz
package TP02;

import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraProduto")
public class AlteraProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		System.out.println("Alterando Produto");
			
		String nomeProduto = request.getParameter("nome");
		String unidadeCompra = request.getParameter("unidade");
		String descricao = request.getParameter("descricao");
		String qtdPrevistoMes = request.getParameter("qtdPrevistoMes");
		String precoMaxComprado = request.getParameter("precoMaxComprado");
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		Integer unidadeId = Integer.valueOf(unidadeCompra);
		Double valorPrevisto = Double.valueOf(qtdPrevistoMes);
		Double valorPreco = Double.valueOf(precoMaxComprado);
		
		System.out.println(id);
		Banco banco = new Banco();
		Produto produto = banco.buscaProdutoPeloId(id);
		produto.setNome(nomeProduto);
		produto.setUnidadeCompra(unidadeId);
		produto.setDescricao(descricao);
		produto.setQtdPrevistoMes(valorPrevisto);
		produto.setPrecoMaxComprado(valorPreco);
		
		response.sendRedirect("listaProdutos");
	}
}