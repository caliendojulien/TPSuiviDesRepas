<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>
<body>
<div class="container">
    <br>
    <h1 class="has-text-primary has-text-centered">Historique</h1>
    <p class="has-text-primary has-text-centered">HISTORIQUE</p>
    <hr>
    <br>
    <div class="columns has-text-centered is-centered">
        <c:forEach var="repas" items="${lesRepas}">
            <div class="tags has-addons">
            <span class="tag is-primary">Repas du <fmt:formatDate pattern="dd/MM/yyyy"
                                                                  value="${repas.date_repas}"/> à ${repas.heure_repas}</span>
                <c:forEach var="aliment" items="${repas.aliments}">
                    <span class="tag is-small">${aliment.nom}</span>
                </c:forEach>
            </div>
        </c:forEach>
    </div>
    <div class="columns">
        <div class="column">
            <a class="has-text-centered has-text-primary is-small" href="/SuiviDesRepas">Retour vers la page
                d'accueil</a>
        </div>
    </div>
</div>
</body>
</html>