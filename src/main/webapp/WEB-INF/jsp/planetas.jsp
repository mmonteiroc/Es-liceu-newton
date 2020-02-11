<%--
  Created by IntelliJ IDEA.
  User: mmonteirocl
  Date: 27/01/2020
  Time: 18:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Planetas</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/css/select2.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/v/bs4/dt-1.10.20/fh-3.1.6/datatables.min.css"/>

</head>
<body>
<c:import url="template/menu.jsp"></c:import>

<main class="container">
    <h1 class="mb-5">Todos los planetas</h1>

    <table>
        <thead>
        <tr>
            <th>Nom</th>
            <th>Satelites</th>
            <th>Modificar</th>
            <th>Eliminar</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="planeta" items="${planetas}">
            <tr>
                <td>
                        ${planeta.nom}
                </td>
                <td>
                    <c:forEach var="satelite" items="${planeta.satelites}">
                        ${satelite.nom}
                    </c:forEach>
                </td>
                <td><a href="planetaForm/${planeta.idplaneta}">Modificar</a></td>
                <td>
                    <form action="deletePlaneta" method="post">
                        <input type="hidden" name="idplaneta" value="${planeta.idplaneta}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>


    </table>
</main>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/bs4/dt-1.10.20/fh-3.1.6/datatables.min.js"></script>
<script>
    // In your Javascript (external .js resource or <script> tag)
    $(document).ready(function () {
        $('table').DataTable()
    });
</script>


</body>
</html>
