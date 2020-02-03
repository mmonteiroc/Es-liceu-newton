<%--
  Created by IntelliJ IDEA.
  User: mmonteirocl
  Date: 03/02/2020
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Add satelite</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/select2@4.0.12/dist/css/select2.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css"
          href="https://cdn.datatables.net/v/bs4/dt-1.10.20/fh-3.1.6/datatables.min.css"/>

</head>
<body>
<c:import url="template/menu.jsp"></c:import>

<main class="container">

    <form action="/addSatelite" method="post">
        <div class="form-row">

            <div class="form-group col-md-6">
                <label for="nomSatelite">Nombre delsatelite</label>
                <input type="text" name="nom" class="form-control" id="nomSatelite">
            </div>
            <div class="form-group col-md-6">
                <label for="massa">Massa del satelite</label>
                <input type="number" class="form-control" name="massa" id="massa">
            </div>
        </div>


        <div class="form-group">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="velocitat">Velocitat del satelite</label>
                    <input type="number" class="form-control" name="velocitat" id="velocitat">
                </div>
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Guardar satelite</button>
    </form>


</main>


</body>
</html>
