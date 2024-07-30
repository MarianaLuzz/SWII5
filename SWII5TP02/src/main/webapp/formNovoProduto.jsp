<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url value="/novoProduto" var="linkServletNovoProduto"/>

<html>
	<head>
		<title>Novo Produto</title>
	</head>
	<body>
		<form action="${linkServletNovoProduto}" method="post">
			<br><h2>Adicionar Novo Produto</h2><br>
			Nome: <input type="text" name="nome" value="${produto.nome}"/><br><br>
			Unidade Compra: <input type="number" name="unidade" value="${produto.unidadeCompra}"/><br><br>
			Descrição: <input type="text" name="descricao" value="${produto.descricao}"/><br><br>
			Qtd. Previsto Mês: <input type="number" name="qtdPrevistoMes" value="${produto.qtdPrevistoMes}"/><br><br>
			Preço Máximo Comprado: <input type="number" name="precoMaxComprado" value="${produto.precoMaxComprado}"/><br><br>
			<input type="submit">
		</form>
		<a href="index.html">Voltar para Página Inicial</a><br><br>
	</body>
</html>