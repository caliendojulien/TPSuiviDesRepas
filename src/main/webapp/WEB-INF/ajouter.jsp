<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/header.jsp"/>
<body>
<div class="container">
    <br>
    <h1 class="has-text-primary has-text-centered">Ajouter un repas</h1>
    <p class="has-text-primary has-text-centered">AJOUTER UN REPAS</p>
    <hr>
    <br>
    <div class="columns has-text-centered is-centered">
        <form action="/SuiviDesRepas/ajouter" method="post">
            <div class="columns">
                <div class="column">
                    <label class="label" for="date">Date : </label><input class="input" type="date" name="date"
                                                                          id="date">
                    <label class="label" for="heure">Heure : </label><input class="input" type="time" name="heure"
                                                                            id="heure">
                </div>
            </div>
            <div class="columns">
                <div class="column">
                    <label class="label" for="aliments">Aliments : </label><textarea class="textarea" name="aliments"
                                                                                     id="aliments"
                                                                                     cols="30"
                                                                                     rows="10"></textarea>
                </div>
            </div>
            <div class="columns">
                <div class="column">
                    <input type="submit" value="Ajouter">
                </div>
            </div>
        </form>
    </div>
    <div class="columns">
        <div class="column">
            <a class="has-text-centered has-text-primary is-small" href="/SuiviDesRepas">Retour vers la page d'accueil</a>
        </div>
    </div>
</div>
</body>
<script>
    document.getElementById("date").valueAsDate = new Date();
    document.getElementById("heure").value = '12:00:00';
</script>
</html>