<%--
  Created by IntelliJ IDEA.
  User: mmonteirocl
  Date: 27/01/2020
  Time: 18:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Form planetas</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/css/select2.min.css" rel="stylesheet"/>
</head>
<body>
<c:import url="template/menu.jsp"></c:import>

<main class="container">

    <form action="/savePlaneta" method="post">
        <div class="form-row">
            <input type="hidden" name="idplaneta" value="${planeta.idplaneta}">

            <div class="form-group col-md-6">
                <label for="nomPlaneta">Nombre del planeta</label>
                <input type="text" name="nom" class="form-control" id="nomPlaneta" value="${planeta.nom}">
            </div>
            <div class="form-group col-md-6">
                <label for="massa">Massa del planeta</label>
                <input type="number" class="form-control" name="massa" id="massa" value="${planeta.massa}">

            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <select class="js-example-basic-multiple" id="satelites" name="satelites[]" multiple="multiple"
                        style="width:80%">
                    <option></option>
                    <c:forEach var="satelite" items="${satelites}">
                        <option value="${satelite.idsatelit}" ${satelite.planeta.idplaneta==planeta.idplaneta?"selected":""}  >${satelite.nom}</option>
                    </c:forEach>
                </select>

            </div>
            <div class="form-group col-md-6">
                <label for="observacion">Observacion</label>
                <input type="text" name="observacion" id="observacion" class="form-control"
                       value="${observacion.comentario}">
            </div>

        </div>
        <div class="form-group">
            <div class="form-check">
                <input type="checkbox" name="habitable" ${planeta.habitable?"checked":""}> Habitable

            </div>
        </div>
        <button type="submit" class="btn btn-primary">Guardar cambios</button>
    </form>


</main>
<script
        src="https://code.jquery.com/jquery-3.4.1.min.js"
        integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/select2@4.0.13/dist/js/select2.min.js"></script>
<script>
    $(document).ready(function () {
        $('.js-example-basic-multiple').select2({
            placeholder: "Satelites (no select nada para no modificar los actuales)",
            allowClear: true
        });
    });
</script>
</body>
</html>
