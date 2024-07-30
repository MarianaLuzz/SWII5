//Mariana Costa da Luz
package TP02;

import java.util.*;

public class Banco{
	private static List<Produto> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;

	static {
		Produto produto = new Produto();
	}
	
	public void adicionaProduto(Produto produto) {
		produto.setId(chaveSequencial++);
		Banco.lista.add(produto);
	}
	
	public List<Produto> getProdutos() {
		return Banco.lista;
	}
	
	public void removeProduto(Integer id) {
		Iterator<Produto> it = lista.iterator();
		
		while(it.hasNext()) {
			Produto prd = it.next();
			
			if(prd.getId() == id) {
				it.remove();
			}
		}
	}
	
	public Produto buscaProdutoPeloId(Integer id) {
		for (Produto produto : lista) {
			if(produto.getId() == id) {
				return produto;
			}
		}
		return null;
	}
}