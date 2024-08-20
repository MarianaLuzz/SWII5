<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aplicação - Inventário de Clientes e Vendedores</title>
</head>
<body>
    <center>
        <h1>Gerenciamento de Clientes</h1>
        <h2>
            <a href="/Prova02/newCustomer">Adicionar Novo Cliente</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Prova02/listCustomer">Listar Todos os Clientes</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Clientes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Nota</th>
                <th>ID do Vendedor</th>
                <th>Ações</th>
            </tr>
            <c:forEach var="customer" items="${listCustomer}">
                <tr>
                    <td><c:out value="${customer.customer_id}" /></td>
                    <td><c:out value="${customer.cust_name}" /></td>
                    <td><c:out value="${customer.city}" /></td>
                    <td><c:out value="${customer.grade}" /></td>
                    <td><c:out value="${customer.salesman_id}" /></td>
                    <td>
                        <a href="/Prova02/edit?id=<c:out value='${customer.customer_id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Prova02/delete?id=<c:out value='${customer.customer_id}' />">Deletar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>