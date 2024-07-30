<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:url value="/alteraProduto" var="linkServletNovoProduto"/>

<html>
	<head>
		<title>Alterar Produtos</title>
	</head>
	<body>
		<form action="${linkServletNovoProduto}" method="post"><br><br>
			Nome: <input type="text" name="nome" value="${produto.nome}"/><br><br>
			Unidade Compra: <input type="number" name="unidade" value="${produto.unidadeCompra}"/><br><br>
			Descri��o: <input type="text" name="descricao" value="${produto.descricao}"/><br><br>
			Qtd. Previsto M�s: <input type="number" name="qtdPrevistoMes" value="${produto.qtdPrevistoMes}"/><br><br>
			Pre�o M�ximo Comprado: <input type="number" name="precoMaxComprado" value="${produto.precoMaxComprado}"/><br><br>
			<input type="hidden" name="id" value="${produto.id}"/>
			<input type="submit">
			<br><br><a href="/SWII5TP02/listaProdutos">Voltar</a><br><br>
		</form>
	</body>
</html>