<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true" %>
<html>
<head>
	<title>Pengundi</title>
</head>
<body>
 <h1> </h1>  
       <form:form method="post" commandName="pengundiForm" action="cari">   
       <c:choose>
       		<c:when test="${sessionScope.pinKod == null}">
       			<fieldset>
		 			<legend>Pengesahan</legend> 
		        	<table align="center">    
			         <tr>    
			          <td>Pin Kod : </td>   
			          <td><form:password path="pinKod" maxlength="8"/></td>
			         </tr>
			         <tr>    
			          <td><br></td>    
						 <td><input type="submit" value="Sahkan" formmethod="post" formaction="<%=request.getContextPath() %>/pengesahan"/></td>
						 <td><form:hidden path="methodName" /></td>
						 <td><form:hidden path="no_kp_carian" /></td>
			         </tr>
			         <tr>    
			          <td><br></td>   
			          	 <c:if test="${not sah && sah != null}">
			          		<td style="color:red;"><c:out value="Pin kod yang dimasukkan tidak sah."></c:out> </td>
			          	</c:if>
			         </tr>
			        </table>     
		        </fieldset>
       		</c:when>
       		<c:otherwise>
       		<fieldset>
        <legend>CARIAN</legend> 
        	<table>  
        	<c:if test="${save}">
          		<td style="color:green;"><c:out value="Maklumat berjaya disimpan."></c:out> </td>
          	</c:if>  
	         <tr>    
	          <td>No Kad Pengenalan : </td>   
	          <td><form:input path="no_kp_carian" maxlength="20"  /></td> 
	         </tr>
	         <tr>    
	          <td><br></td>
	          <td><input type="submit" value="Cari" /></td>
	         </tr>
	         <tr>    
	          <td><br></td>
	          <c:choose>
	          	<c:when test="${pengundiForm.warning == 'no_kp_null'}">
	          		<td style="color:red;"><c:out value="Sila masukan nombor pengenalan."></c:out> </td>
	          	</c:when>
	          	<c:when test="${pengundiForm.warning == 'Data_null'}">
	          		<td style="color:red;"><c:out value="Maklumat pengundi ini tiada dalam pengkalan data."></c:out> </td>
	          		<td><input type="submit" formaction="<%=request.getContextPath() %>/tambah" value="Tambah" /></td>
	          	</c:when>
	          	<c:otherwise>
	          		<td style="color:red;"><form:label path="warning"/><c:out value="${pengundiForm.warning}"></c:out> </td>
	          	</c:otherwise>
	          </c:choose>
	         </tr>
	        </table>     
        </fieldset>
        <br>
       <fieldset>
        <legend> MAKLUMAT PENGUNDI</legend>
       	<table>
       		<tr>    
	          <td>No Kad Pengenalan : </td>   
	          <td><form:label path="no_kp" maxlength="255"  disabled="true"/> <c:out value="${pengundi.noKp}"></c:out></td>
	          <td><form:hidden path="no_kp"/> </td>
	         </tr>
	         <tr>    
	          <td>Nama :</td>    
	          <td><form:label path="nama" maxlength="255"  disabled="true"/> <c:out value="${pengundi.nama}"></c:out></td>  
	         </tr>   
	         <tr>    
	          <td>Jantina :</td>    
	          <td><form:label path="jantina" maxlength="1"  disabled="true"/><c:out value="${pengundi.jantina}"></c:out></td>  
	         </tr>
	         <tr>    
	          <td>DM :</td>    
	          <td><form:label path="dm" maxlength="100"  disabled="true"/><c:out value="${pengundi.dm}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Kod Lokaliti :</td>    
	          <td><form:label path="kod_lokaliti" maxlength="255"  disabled="true"/><c:out value="${pengundi.kodLokaliti}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Lokaliti :</td>    
	          <td><form:label path="lokaliti" maxlength="500"  disabled="true"/><c:out value="${pengundi.lokaliti}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Umur :</td>    
	          <td><form:label path="kump_umur" maxlength="100"  disabled="true"/><c:out value="${pengundi.kumpUmur}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Kaum :</td>    
	          <td><form:label path="kump_kaum" maxlength="100"  disabled="true"/><c:out value="${pengundi.kumpKaum}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>No. Telefon 1 :</td>
	          	<td><form:label path="tel_no1" maxlength="500"  /><c:out value="${pengundi.telNo1}"></c:out></td>
	         </tr> 
	         <tr>    
	          <td>No. Telefon 2 :</td>  
	          <c:choose>
				<c:when test="${mode}">
					 <td><form:label path="tel_no2" maxlength="500"  /><c:out value="${pengundi.telNo2}"></c:out></td>  
				</c:when>
				<c:otherwise>
					   <td><form:input path="tel_no2" id="tel_no2" maxlength="200" onkeyup="validate1();" /></td>  
				</c:otherwise>
			 </c:choose>  
	         </tr> 
	          <tr id="msg2t" style="display: none;">    
	          	<td><br></td>   
          		<td style="color:red;"><c:out value="Sila masukkan nombor telefon yang betul."></c:out> </td>
	          </tr>  
	         <tr>    
	          <td>Alamat :</td>
	          <c:choose>
				<c:when test="${mode}">
					 <td><form:label path="alamat" maxlength="500"  /><c:out value="${pengundi.alamat}"></c:out></td>  
				</c:when>
				<c:otherwise>
					  <td><form:textarea path="alamat" maxlength="500" /></td>  
				</c:otherwise>
			 </c:choose>    
	         </tr> 
	         <tr>    
	          <td>Alamat ST4 :</td>    
	          <td><form:label  path="alamat_st4" maxlength="500"   disabled="true"/><c:out value="${pengundi.alamatSt4}"></c:out></td>  
	         </tr> 
	         <tr>    
	          <td>Negeri :</td>
	          <c:choose>
				<c:when test="${mode}">
					 <td><form:label path="negeri" maxlength="500"  /><c:out value="${pengundi.negeri}"></c:out></td>  
				</c:when>
				<c:otherwise>
					   <td>
			          	<form:select path="negeri">
		          		<form:option value="" label=""/>
		          		<c:forEach items="${negeriL}" var="negeri">
					            <form:option value="${negeri}" label="${negeri}"/>
					    </c:forEach>
		    		    </form:select>
		    		   </td> 
				</c:otherwise>
			 </c:choose>      
	         </tr>
	         <tr>    
	          <td>Kategori :</td>
	          <c:choose>
				<c:when test="${mode}">
					 <td><form:label path="category" maxlength="500"  /><c:out value="${pengundiForm.category}"></c:out></td>  
				</c:when>
				<c:otherwise>
					   <td>
			          	<form:select path="category" disabled="${mode}">
		          		<form:option value="" label=""/>
		          		<form:option value="A" label="Kategori A : Pengundi Luar Hadir Program"/>
		          		<form:option value="B" label="Kategori B : Pengundi Luar Tidak Hadir Program (Putih)"/>
		          		<form:option value="C" label="Kategori C : Pengundi Luar Tiada Kerjasama (Hitam)"/>
		          		<form:option value="D" label="Kategori D : Tidak Angkat Phone "/>
		          		<form:option value="E" label="Kategori E : No Tiada Dalam Service / Voice Messages "/>
		          		<form:option value="F" label="Kategori F : Belum Dapat Dihubungi (Tiada Phone No)"/>
		          		<form:option value="G" label="Kategori G : Confirm Pengundi Dalam"/>
		          		<form:option value="H" label="Kategori H : Tidak Dikenal Pasti"/>
		          		<form:option value="I" label="Kategori I : Pengundi Awal"/>
		          		<form:option value="J" label="Kategori J : Pengundi Pos"/>
		          		<form:option value="K" label="Kategori K : Bukan Pengundi Putrajaya"/>
		    		    </form:select>
		    		  </td> 
				</c:otherwise>
			 </c:choose> 
	         </tr> 
	         <tr>    
	          <td><br></td>    
	          <c:choose>
				<c:when test="${mode}">
				    <c:if test="${aCat != 'A'}">
					 <td><input type="submit"  formaction="<%=request.getContextPath() %>/kemaskini"  value="Kemaskini" /></td>
					 </c:if>
				</c:when>
				<c:otherwise>
					 <td><input type="submit" formaction="<%=request.getContextPath() %>/save"  value="Simpan" /></td>
				</c:otherwise>
			 </c:choose>
	         </tr>   
	         <tr>    
	          <td><br></td>   
	          <c:if test="${saveKemaskini}">
          		<td style="color:green;"><c:out value="Maklumat berjaya disimpan."></c:out> </td>
          		</c:if> 
	         </tr>  
	         <tr>    
	          <td><br></td>    
	         </tr> 
        </table>    
       </fieldset>
      </c:otherwise>
         </c:choose>
        
       </form:form>    
</body>
<script type="text/javascript">
function validate1(){
	var str1, text;
	 str1 = document.getElementById("tel_no2").value;
	 var x = document.getElementById("msg2t");
	if(isNaN(str1)){
		 x.style.display = "block";
	 }else{
		 text ="";
		 x.style.display = "none";
	 }
}

</script>
</html>
