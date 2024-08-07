<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Aplicação - Loja de Livros</title>
</head>
<body>
    <center>
        <h1>Gerenciamento de Livros</h1>
        <h2>
            <a href="/Bookstore/new">Adicionar Novo Livro</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/Bookstore/list">Listar Todos os Livros</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Books</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="book" items="${listBook}">
                <tr>
                    <td><c:out value="${book.id}" /></td>
                    <td><c:out value="${book.title}" /></td>
                    <td><c:out value="${book.author}" /></td>
                    <td><c:out value="${book.price}" /></td>
                    <td>
                        <a href="/Bookstore/edit?id=<c:out value='${book.id}' />">Editar</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/Bookstore/delete?id=<c:out value='${book.id}' />">Deletar</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="/Bookstore/creditos">Créditos do Trabalho</a>
    </div>   
</body>
</html>