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
	          <td><form:input path="nama" maxlength="255"  disabled="true"/></td>  
	         </tr>   
	         <tr>    
	          <td>Jantina :</td>    
	          <td><form:input path="jantina" maxlength="1"  disabled="true"/></td>  
	         </tr>
	         <tr>    
	          <td>DM :</td>    
	          <td><form:input path="dm" maxlength="100"  disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Kod Lokaliti :</td>    
	          <td><form:input path="kod_lokaliti" maxlength="255"  disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Lokaliti :</td>    
	          <td><form:input path="lokaliti" maxlength="500"  disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Umur :</td>    
	          <td><form:input path="kump_umur" maxlength="100"  disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Kaum :</td>    
	          <td><form:input path="kump_kaum" maxlength="100"  disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>No. Telefon 1 :</td>    
	          <td><form:input path="tel_no1" maxlength="200"  disabled="${mode}"/></td>  
	         </tr> 
	         <tr>    
	          <td>No. Telefon 2 :</td>    
	          <td><form:input path="tel_no2" maxlength="200"  disabled="${mode}"/></td>  
	         </tr> 
	         <tr>    
	          <td>Alamat :</td>    
	          <td><form:textarea path="alamat" maxlength="500" size="50"  disabled="${mode}"/></td>  
	         </tr> 
	         <tr>    
	          <td>Alamat ST4 :</td>    
	          <td><form:textarea  path="alamat_st4" maxlength="500"   disabled="true"/></td>  
	         </tr> 
	         <tr>    
	          <td>Kategori A :</td>
	          <td>
	          	<form:select path="category_a" maxlength="1"  disabled="${mode}">
          		<form:option value="" label=""/>
          		<form:option value="Y" label="Y"/>
    		    </form:select>
    		  </td>    
	         </tr> 
	         <tr>    
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
	         </tr>   
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
