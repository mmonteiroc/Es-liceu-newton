<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Es Liceu newton</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo02"
            aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <c:if test="${username==null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login </a>
                </li>
            </c:if>
            <c:if test="${username!=null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/planetas">Todos los planetas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/planetaForm">Añadir planeta</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/planetas/comentarios">Ver todos tus
                        observacion</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/addSatelite">Añadir satelite</a>
                </li>
            </c:if>
        </ul>


    </div>
</nav>