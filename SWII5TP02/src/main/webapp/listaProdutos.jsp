<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Lista de Produtos</title>
	</head>
	<body>
		<c:if test="${not empty produtos}">
		<br><h2>Lista de Produtos</h2><br>
			<table border="1">
				<tr align="center">
					<td> ID </td>
					<td> Nome Produto </td>
					<td> Unidade Compra </td>
					<td> Descricao </td>
					<td> QtdPrevistaMes </td>
					<td> PrecoMax </td>
				</tr>
				<c:forEach items="${produtos}" var="produto">
					<tr>
						<td>${produto.id}</td> 
						<td>${produto.nome}</td>
						<td>${produto.unidadeCompra}</td>
						<td>${produto.descricao}</td>
						<td>${produto.qtdPrevistoMes}</td>
						<td>${produto.precoMaxComprado}</td>
						<td> <a href="/SWII5TP02/mostraProduto?id=${produto.id}"> Editar </a> </td>
						<td> <a href="/SWII5TP02/removeProduto?id=${produto.id}"> Remover </a> </td>
					</tr>
				</c:forEach>
			</table>
			<br><br><br><a href="index.html">Voltar para Página Inicial</a><br><br>
		</c:if>
		
		<c:if test="${empty produtos}">
			Não existem produtos cadastrados!
			<br><br><a href="formNovoProduto.jsp">Cadastrar Novo Produto</a><br><br>
			<a href="index.html">Voltar para Página Inicial</a><br><br>
		</c:if>		
	</body>
</html>