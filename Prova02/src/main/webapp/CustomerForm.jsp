<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aplicação - Inventário de Cliente e Vendedores</title>
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
        <c:if test="${customer != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${customer == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${customer != null}">
                        Editar Cliente
                    </c:if>
                    <c:if test="${customer == null}">
                        Adicionar Novo Cliente
                    </c:if>
                </h2>
            </caption>
                <c:if test="${customer != null}">
                    <input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
                </c:if>           
            <tr>
                <th>Nome: </th>
                <td>
                    <input type="text" name="nome" size="45"
                            value="<c:out value='${customer.cust_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Cidade: </th>
                <td>
                    <input type="text" name="cidade" size="45"
                            value="<c:out value='${customer.city}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Nota: </th>
                <td>
                    <input type="text" name="nota" size="5"
                            value="<c:out value='${customer.grade}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>IDVendedor: </th>
                <td>
                    <input type="text" name="vendedor" size="5"
                            value="<c:out value='${customer.salesman_id}' />"
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