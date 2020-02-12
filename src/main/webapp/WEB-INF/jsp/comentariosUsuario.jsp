<%--
  Created by IntelliJ IDEA.
  User: mmonteirocl
  Date: 29/01/2020
  Time: 02:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tus comentarios</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

</head>
<body>

<c:import url="template/menu.jsp"></c:import>
<h1>Comentarios del usuario: ${usuario.nom} ${usuario.cognoms}</h1>
<ul>
    <c:forEach var="c" items="${Comentarios}">
        <li>
                ${c.planetaUsuariPlanetas.nom} tiene el comentario: ${c.comentario}

            <form action="${pageContext.request.contextPath}/comentarios/delete" method="post">
                <input type="hidden" name="idUsuario" value="${c.usuari.idusuari}">
                <input type="hidden" name="idPlaneta" value="${c.planetaUsuariPlanetas.idplaneta}">
                <input type="hidden" name="comentario" value="${c.comentario}">

                <input type="submit" value="Delete coment">
            </form>
        </li>
    </c:forEach>
</ul>


</body>
</html>
