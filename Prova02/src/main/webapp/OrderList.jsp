<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aplicação - Inventário de Clientes e Vendedores</title>
</head>
<body>
    <center>
        <h1>Gerenciamento de Pedidos</h1>
        <h2>
            <a href="/Prova02/newOrder">Adicionar Novo Pedido</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Prova02/listOrder">Listar Todos os Pedidos</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Pedidos</h2></caption>
            <tr>
                <th>Número do Pedido</th>
                <th>Quantidade</th>
                <th>Data</th>
                <th>Cliente</th>
                <th>Vendedor</th>
            </tr>
            <c:forEach var="order" items="${listOrder}">
                <tr>
                    <td><c:out value="${order.ord_no}" /></td>
                    <td><c:out value="${order.purch_amt}" /></td>
                    <td><c:out value="${order.ord_date}" /></td>
                    <td><c:out value="${order.customer_id}" /></td>
                    <td><c:out value="${order.salesman_id}" /></td>
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