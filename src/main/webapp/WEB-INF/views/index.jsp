<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
	<title>Pengundi</title>
</head>
<body>
    <h1></h1>  
       <form:form method="post" commandName="pengundiForm"  action="pengesahan">
              <c:out value='${sessionScope.pinKod}'/>
       <c:choose>
       		<c:when test="${pinKod == null}">
       			<fieldset>
		 			<legend>Pengesahan</legend> 
		        	<table align="center">    
			         <tr>    
			          <td>Pin kod : </td>   
			          <td><form:password path="pinKod" maxlength="8"/></td>
			         </tr>
			         <tr>    
			          <td><br></td>    
						 <td><input type="submit" value="Sahkan" /></td>
						 <td><form:hidden path="methodName" /></td>
			         </tr>
			        </table>     
		        </fieldset>
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
		           <td><a href="" ><button  style="padding: 20px 40px">Senarai Pengundi</button></a></td>
		         </tr>
		        </table>     
	        </fieldset>
	        </c:otherwise>
         </c:choose>
        </form:form>
</body>
<script type="text/javascript">
	/* var person = prompt("Please enter your name", "Harry Potter");
	if (person != null) {
// 	    document.getElementById("demo").innerHTML =
// 	    "Hello " + person + "! How are you today?";
	} */
</script>
</html>
