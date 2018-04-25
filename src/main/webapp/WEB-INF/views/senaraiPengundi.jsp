<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<style>
table {
    width:100%;
}
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
    text-align: left;
}
table#t01 tr:nth-child(even) {
    background-color: #eee;
}
table#t01 tr:nth-child(odd) {
   background-color: #fff;
}
table#t01 th {
    background-color: black;
    color: white;
}
</style>
<html>
<head>
	<title>Senarai Pengundi</title>
</head>
<body>
 <h1> </h1>  
     <fieldset>
      <legend>Senarai Pengundi</legend> 
      	<table id="t01">
		  <tr>
		    <th>No Pengenalan</th>
		    <th>Nama</th> 
		  </tr>
		  <c:forEach items="${negeriL}" var="p">
            <tr>
			    <td>${p.noKp}</td>
			    <td>${p.nama}</td>
		  	</tr>
	     </c:forEach>
		</table>  
      </fieldset>
</body>
</html>
