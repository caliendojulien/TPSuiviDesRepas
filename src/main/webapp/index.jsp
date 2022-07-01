<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/header.jsp"/>
<body>
<div class="container">
    <br>
    <h1 class="has-text-primary has-text-centered">Suivi des repas</h1>
    <p class="has-text-primary has-text-centered">SUIVI DES REPAS</p>
    <hr>
    <br>
    <div class="columns">
        <div class="column is-half is-offset-one-quarter has-text-centered">
            <a class="button is-primary is-small is-rounded" href="/SuiviDesRepas/ajouter">Ajouter un repas </a>
        </div>
    </div>
    <div class="columns">
        <div class="column is-half is-offset-one-quarter has-text-centered">
            <a class="button is-primary is-small is-rounded" href="/SuiviDesRepas/historique">Historique</a>
        </div>
    </div>
</div>
</body>
</html>