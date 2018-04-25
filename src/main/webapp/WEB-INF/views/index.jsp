<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true" %>
<html>
<head>
	<title>Pengundi</title>
</head>
<body>
    <h1></h1>  
      
       <c:choose>
       		<c:when test="${sessionScope.pinKod == null}">
       		 <form:form method="post" commandName="pengundiForm"  action="pengesahan">
       			<fieldset>
		 			<legend>Pengesahan</legend> 
		        	<table align="center">    
			         <tr>    
			          <td>Pin Kod : </td>   
			          <td><form:password path="pinKod" maxlength="8"/></td>
			         </tr>
			         <tr>    
			          <td><br></td>    
						 <td><input type="submit" value="Sahkan" /></td>
						 <td><form:hidden path="methodName" /></td>
			         </tr>
			         <tr>    
			          <td><br></td>   
			          	 <c:if test="${not sah}">
			          		<td style="color:red;"><c:out value="Pin kod yang dimasukkan tidak sah."></c:out> </td>
			          	</c:if>
			         </tr>
			        </table>     
		        </fieldset>
		         </form:form>
       		</c:when>
       		<c:otherwise>
	       <fieldset>
	        <legend>Menu</legend> 
	        	<table align="center">    
		         <tr>    
		          <td><a href="carianPengundi"><button  style="padding: 20px 40px">Carian Pengundi</button></a></td>
		         </tr>
		         <tr><td><br></td></tr>
		         <tr>    
		           <td><a href="senaraiPengundi" ><button  style="padding: 20px 40px">Senarai Pengundi</button></a></td>
		         </tr>
		        </table>     
	        </fieldset>
	        </c:otherwise>
         </c:choose>
       
</body>
<script type="text/javascript">
	/* var person = prompt("Please enter your name", "Harry Potter");
	if (person != null) {
// 	    document.getElementById("demo").innerHTML =
// 	    "Hello " + person + "! How are you today?";
	} */
</script>
</html>
