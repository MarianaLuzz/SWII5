<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aplicação - Inventário de Clientes e Vendedores</title>
</head>
<body>
    <center>
        <h1>Gerenciamento de Vendedores</h1>
        <h2>
            <a href="/Prova02/newSalesman">Adicionar Novo Vendedor</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Prova02/listSalesman">Listar Todos os Vendedores</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Clientes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Comissão</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="salesman" items="${listSalesman}">
                <tr>
                    <td><c:out value="${salesman.salesman_id}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.city}" /></td>
                    <td><c:out value="${customer.commission}" /></td>
                    <td>
                        <a href="/Prova02/edit?id=<c:out value='${salesman.salesman_id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Prova02/delete?id=<c:out value='${salesman.salesman_id}' />">Deletar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>