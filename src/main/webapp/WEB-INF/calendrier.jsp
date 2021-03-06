<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${sessionScope.utilisateur eq null}">
<jsp:forward page="index"></jsp:forward>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calendrier</title>
<link href="style/${sessionScope.utilisateur.theme.nom.toLowerCase()}.css" rel="stylesheet">
</head>
<body>
<h1>Calendrier</h1>
<h2>Utilisateur : ${sessionScope.utilisateur.prenom} - solde : ${sessionScope.utilisateur.nbPoints} points <a href="deconnexion">Déconnexion</a></h2>
<table id="calendrier">
<tr>
<td>Jour</td>
<td>Gif</td>
<td>Utilisateur</td>
<td>Réaction(s)</td>
</tr>
<c:forEach items="${pageDeJours.content}" var="jour">
<tr>
<td>${jour}</td>
<c:choose>
<c:when test="${jour.gif eq null }">
<td colspan="3">
${jour.nbPoints} points<br>
<a href="placerGifDistant?ID_JOUR=${jour.date}">Placer un Gif distant</a><br>
</td>
</c:when>
<c:when test="${jour.gif ne null }">
<td>
<c:if test="${jour.gif.legende ne null}"><h2>${jour.gif.legende}</h2></c:if>
<c:if test="${jour.gif.getClass().simpleName eq 'GifDistant'}"><img src="${jour.gif.url}" height="200"></c:if></td>
<td>${jour.gif.utilisateur.prenom}</td>
<td>
<c:forEach items="${jour.gif.reactions}" var="reaction">
${reaction.emotion.code} ${reaction.utilisateur.prenom}<br>
</c:forEach>
<a href="reagir?ID_GIF=${jour.gif.id}">Réagir</a></td>
</c:when>
</c:choose>
</tr>
</c:forEach>
</table>
<h2>
<c:if test="${!pageDeJours.first}">
<a href="calendrier?page=0&sort=${sort}">&#x23EE;</a>
<a href="calendrier?page=${pageDeJours.number-1}&sort=${sort}">&#x23EA;</a>
</c:if>
Page ${pageDeJours.getNumber()+1}
<c:if test="${!pageDeJours.last}">
<a href="calendrier?page=${pageDeJours.number+1}&sort=${sort}">&#x23E9;</a>
<a href="calendrier?page=${pageDeJours.totalPages - 1}&sort=${sort}">&#x23ED;</a>
</c:if>
</h2>
<jsp:include page="piedDePage.jsp"></jsp:include>
</body>
</html>