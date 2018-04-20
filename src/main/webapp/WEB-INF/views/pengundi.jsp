<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<html>
<head>
	<title>Pengundi</title>
</head>
<body>
 <h1> </h1>  
       <form:form method="post" commandName="pengundiForm" action="cari">   
       <fieldset>
        <legend>CARIAN</legend> 
        	<table>    
	         <tr>    
	          <td>No Kad Pengenalan : </td>   
	          <td><form:input path="no_kp" maxlength="20"  /></td> 
	         </tr>
	         <tr>    
	          <td><br></td>
	          <td><input type="submit" value="Cari" /></td>
	         </tr>
	        </table>     
        </fieldset>
        <br>
       <fieldset>
        <legend> MAKLUMAT PENGUNDI</legend>
       	<table>
	         <tr>    
	          <td>Nama :</td>    
	          <td><form:label path="nama" maxlength="255"  disabled="true"/> <c:out value="${pengundiForm.nama}"></c:out></td>  
	         </tr>   
	         <tr>    
	          <td>Jantina :</td>    
	          <td><form:label path="jantina" maxlength="1"  disabled="true"/><c:out value="${pengundiForm.jantina}"></c:out></td>  
	         </tr>
	         <tr>    
	          <td>DM :</td>    
	          <td><form:label path="dm" maxlength="100"  disabled="true"/><c:out value="${pengundiForm.dm}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Kod Lokaliti :</td>    
	          <td><form:label path="kod_lokaliti" maxlength="255"  disabled="true"/><c:out value="${pengundiForm.kod_lokaliti}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Lokaliti :</td>    
	          <td><form:label path="lokaliti" maxlength="500"  disabled="true"/><c:out value="${pengundiForm.lokaliti}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Umur :</td>    
	          <td><form:label path="kump_umur" maxlength="100"  disabled="true"/><c:out value="${pengundiForm.kump_umur}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Kaum :</td>    
	          <td><form:label path="kump_kaum" maxlength="100"  disabled="true"/><c:out value="${pengundiForm.kump_kaum}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>No. Telefon 1 :</td>
	          	<c:choose>
				<c:when test="${mode}">
					 <td><form:label path="tel_no1" maxlength="500"  /><c:out value="${pengundiForm.tel_no1}"></c:out></td>  
				</c:when>
				<c:otherwise>
					   <td><form:input path="tel_no1" maxlength="200"  /></td>  
				</c:otherwise>
			 	</c:choose>    
	         </tr> 
	         <tr>    
	          <td>No. Telefon 2 :</td>  
	          <c:choose>
				<c:when test="${mode}">
					 <td><form:label path="tel_no2" maxlength="500"  /><c:out value="${pengundiForm.tel_no2}"></c:out></td>  
				</c:when>
				<c:otherwise>
					   <td><form:input path="tel_no2" maxlength="200"  /></td>  
				</c:otherwise>
			 </c:choose>  
	         </tr> 
	         <tr>    
	          <td>Alamat :</td>
	          <c:choose>
				<c:when test="${mode}">
					 <td><form:label path="alamat" maxlength="500"  /><c:out value="${pengundiForm.alamat}"></c:out></td>  
				</c:when>
				<c:otherwise>
					  <td><form:textarea path="alamat" maxlength="500"  /></td>  
				</c:otherwise>
			 </c:choose>    
	         </tr> 
	         <tr>    
	          <td>Alamat ST4 :</td>    
	          <td><form:label  path="alamat_st4" maxlength="500"   disabled="true"/><c:out value="${pengundiForm.alamat_st4}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Kategori :</td>
	          <c:choose>
				<c:when test="${mode}">
					 <td><form:label path="category_a" maxlength="500"  /><c:out value="${pengundiForm.category_a}"></c:out></td>  
				</c:when>
				<c:otherwise>
					   <td>
			          	<form:select path="category_a" maxlength="1"  disabled="${mode}">
		          		<form:option value="" label=""/>
		          		<form:option value="A" label="A"/>
		          		<form:option value="B" label="B"/>
		          		<form:option value="C" label="C"/>
		          		<form:option value="D" label="D"/>
		          		<form:option value="E" label="E"/>
		          		<form:option value="F" label="F"/>
		          		<form:option value="G" label="G"/>
		          		<form:option value="H" label="H"/>
		          		<form:option value="I" label="I"/>
		    		    </form:select>
		    		  </td> 
				</c:otherwise>
			 </c:choose> 
	              
	         </tr> 
	         <%-- <tr>    
	          <td>Kategori B :</td>
	          <td>
	          	<form:select path="category_b" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select>
    		  </td>    
	         </tr> 
	         <tr>    
	          <td>Kategori C :</td>    
	          <td>	
          		<form:select path="category_c" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select> 		
	          </td>  
	         </tr> 
	         <tr>    
	          <td>Kategori D :</td>    
	          <td>
	          	<form:select path="category_d" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select>
    		  </td>  
	         </tr> 
	         <tr>    
	          <td>Kategori E :</td>
	          <td>
	          	<form:select path="category_e" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select>
    		  </td>    
	         </tr> 
	         <tr>    
	          <td>Kategori F :</td>
	          <td>
	          	<form:select path="category_f" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select>
    		  </td>    
	         </tr> 
	         <tr>    
	          <td>Kategori G :</td>
	          <td>
	          	<form:select path="category_g" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select>
    		  </td>    
	         </tr> 
	         <tr>    
	          <td>Kategori H :</td>
	           <td>
	          	<form:select path="category_h" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select>
    		  </td>    
	         </tr> 
	         <tr>    
	          <td>Flag Masuk :</td>    
	          <td><form:input path="flag_masuk" maxlength="1"   disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Flag Keluar :</td>    
	          <td><form:input path="flag_keluar" maxlength="1"  disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Status Pengundi :</td>    
	          <td><form:input path="status_pengundi" maxlength="10"  disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Status Alamat :</td>    
	          <td><form:input path="status_alamat" maxlength="50"   disabled="true" /></td>  
	         </tr>    --%>
	         <tr>    
	          <td><br></td>    
	          <c:choose>
				<c:when test="${mode}">
					 <td><input type="submit" formaction="kemaskini"  value="Kemaskini" /></td>
				</c:when>
				<c:otherwise>
					 <td><input type="submit" formaction="save"  value="Simpan" /></td>
				</c:otherwise>
			 </c:choose>
	         </tr>    
        </table>    
       </fieldset>
        
       </form:form>    
</body>
</html>
