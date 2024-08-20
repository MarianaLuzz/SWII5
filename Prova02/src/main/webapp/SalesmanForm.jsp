<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aplicação - Inventário de Cliente e Vendedores</title>
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
        <c:if test="${salesman != null}">
            <form action="updateSalesman" method="post">
        </c:if>
        <c:if test="${salesman == null}">
            <form action="insertSalesman" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${salesman != null}">
                        Editar Vendedor
                    </c:if>
                    <c:if test="${salesman == null}">
                        Adicionar Novo Vendedor
                    </c:if>
                </h2>
            </caption>
                <c:if test="${salesman != null}">
                    <input type="hidden" name="id" value="<c:out value='${salesman.salesman_id}' />" />
                </c:if>           
            <tr>
                <th>Nome do Vendedor: </th>
                <td>
                    <input type="text" name="name" size="45"
                            value="<c:out value='${salesman.name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Cidade: </th>
                <td>
                    <input type="text" name="city" size="45"
                            value="<c:out value='${salesman.city}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Comissão: </th>
                <td>
                    <input type="number" name="commission" size="5"
                            value="<c:out value='${salesman.commission}' />"
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