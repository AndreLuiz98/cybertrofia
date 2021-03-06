<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>

	<c:set var="resultadocalcIMC" scope="session" value="pessoas" />

	<c:if test="${(resultadocalcIMC >= 16)  && (resultadocalcIMC <= 16.99)}">
		<!-- Baixo peso grave = IMC entre 16 e 16,99 -->
		<p>Voc� esta na situa��o de um PESO BAIXO GRAVE
		<p>
	</c:if>
	<c:if test="${(resultadocalcIMC >= 17)  && (resultadocalcIMC <= 18.49)}">
		<!-- Baixo peso = IMC entre 17 e 18,49 -->
		<p>Voc� esta na situa��o de um PESO BAIXO
		<p>
	</c:if>
	<c:if test="${(resultadocalcIMC >= 18.50)  && (resultadocalcIMC <= 24.99)}">
		<!-- Peso normal = IMC entre 18,50 e 24,99 -->
		<p>Voc� esta na situa��o de um PESO NORMAL
		<p>
	</c:if>
	<c:if test="${(resultadocalcIMC >= 25)  && (resultadocalcIMC <= 29.99)}">
		<!-- Sobrepeso = IMC entre 25 e 29,99 -->
		<p>Voc� esta na situa��o de um SOBREPESO
		<p>
	</c:if>
	<c:if test="${(resultadocalcIMC >= 30)  && (resultadocalcIMC <= 34.99)}">
		<!-- Obesidade grau I = IMC entre 30 e 34,99 -->
		<p>Voc� esta na situa��o de uma OBESIDADE GRAU I
		<p>
	</c:if>
	<c:if test="${(resultadocalcIMC >= 35)  && (resultadocalcIMC <= 39.99)}">
		<!-- Obesidade grau II = IMC entre 35 e 39,99 -->
		<p>Voc� esta na situa��o de uma OBESIDADE GRAU II
		<p>
	</c:if>
	<c:if test="${(resultadocalcIMC >= 40)}">
		<!-- Obesidade grau III (obesidade m�rbida) = IMC maior que 40 -->
		<p>Voc� esta na situa��o de uma OBESIDADE GRAU III (OBESIDADE M�RBIDA)
		<p>
	</c:if>
</body>
</html>