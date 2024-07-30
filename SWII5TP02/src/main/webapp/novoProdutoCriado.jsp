<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<c:if test="${not empty produtos}">
			<br><h2>Produto cadastrado com sucesso!</h2><br>
			<a href="/SWII5TP02/listaProdutos">Lista de Produto</a><br><br>
			<a href="index.html">Voltar para Home</a><br><br>
		</c:if>
		
		<c:if test="${empty produtos}">
			Não existem produtos cadastrados!
			<br><br><a href="formNovoProduto.jsp">Cadastrar Novo Produto</a><br><br>
			<a href="index.html">Voltar para Página Inicial</a><br><br>
		</c:if>		
		
	</body>
</html>