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
    padding: 2px;
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

.pagination {
    display: inline-block;
}

.pagination a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
}

.pagination a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
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
		  <c:forEach items="${mpl}" var="p">
            <tr>
			    <td><a href="<%=request.getContextPath() %>/pengundi/${p.noKp}">${p.noKp}</a></td>
			    <td>${p.nama}</td>
		  	</tr>
	     </c:forEach>
		</table> 
		<br>
<%-- 		<c:out value="<%=request.getContextPath() %>"></c:out> --%>
		<div class="pagination">
		<c:if test="${pageNo > 2}">
		  <a href="<%=request.getContextPath() %>/senaraiPengundi/1">Pertama</a>
		</c:if>
		<c:if test="${pageNo > 1}">
		  <a href="<%=request.getContextPath() %>/senaraiPengundi/${pageNo-1}">Sebelum</a>
		</c:if>  
		<c:if test="${pageNo >= 1 && pageNo != lastPage}">
		 <a href="<%=request.getContextPath() %>/senaraiPengundi/${pageNo+1}">Seterus</a>
		</c:if>
		 <c:if test="${pageNo >= 2 && pageNo != lastPage}">
		  <a href="<%=request.getContextPath() %>/senaraiPengundi/${lastPage}">Terakhir</a>
		</c:if>
		</div> 
		
      </fieldset>
</body>
</html>
