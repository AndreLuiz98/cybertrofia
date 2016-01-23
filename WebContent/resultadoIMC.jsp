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

	<c:set var ="pesoKG" value="${peso}"/>
	<c:set var="Alturacm" value="${altura}"/>
	<c:forEach var="x1" items="1">  
	<fmt:formatNumber var="resultado_imc" value="${peso/(altura)*(altura)}" 
	pattern="#####0.00"/>  
	${resultado_imc}      
	</c:forEach>  
	
</body>
</html>