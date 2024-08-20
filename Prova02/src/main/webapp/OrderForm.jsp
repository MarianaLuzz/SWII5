<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aplicação - Inventário de Cliente e Vendedores</title>
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
        <c:if test="${order != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${order == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${order != null}">
                        Editar Pedido
                    </c:if>
                    <c:if test="${customer == null}">
                        Adicionar Novo Pedido
                    </c:if>
                </h2>
            </caption>
                <c:if test="${order != null}">
                    <input type="hidden" name="id" value="<c:out value='${order.ord_no}' />" />
                </c:if>           
            <tr>
                <th>Quantidade Comprada: </th>
                <td>
                    <input type="text" name="qtd" size="45"
                            value="<c:out value='${order.purch_amt}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Data: </th>
                <td>
                    <input type="text" name="data_pedido" size="45"
                            value="<c:out value='${order.ord_date}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>IDCliente: </th>
                <td>
                    <input type="text" name="cliente" size="5"
                            value="<c:out value='${order.customer_id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>IDVendedor: </th>
                <td>
                    <input type="text" name="vendedor" size="5"
                            value="<c:out value='${order.salesman_id}' />"
                    />
                </td>
            </tr>
            
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Salvar" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>