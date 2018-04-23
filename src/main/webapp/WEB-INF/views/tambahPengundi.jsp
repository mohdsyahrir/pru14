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
       <form:form method="post" commandName="mp" action="saveBaru">   
        <br>
       <fieldset>
        <legend> MAKLUMAT PENGUNDI</legend>
       	<table>
       		<tr>    
	          <td>No Kad Pengenalan : </td>   
	          <td><form:input path="noKp" maxlength="255"/></td>
	         </tr>
	         <tr>    
	          <td>Nama :</td>    
	          <td><form:input path="nama" maxlength="255"/></td>  
	         </tr>   
	         <tr>    
	          <td>Jantina :</td>    
	           <td>
	          	<form:select path="jantina">
          		<form:option value="" label=""/>
          		<form:option value="L" label="Lelaki"/>
          		<form:option value="P" label="Perempuan"/>
    		    </form:select>
    		  </td>  
	         </tr>
	         <tr>    
	          <td>DM :</td>    
	          <td>
	          	<form:select path="dm">
          		<form:option value="" label=""/>
          		<form:option value="DM01 TAMAN SAUJANA HIJAU" label="DM01 TAMAN SAUJANA HIJAU"/>
          		<form:option value="DM02 TAMAN RIMBA DESA UTARA" label="DM02 TAMAN RIMBA DESA UTARA"/>
          		<form:option value="DM03 TAMAN RIMBA DESA TIMUR" label="DM03 TAMAN RIMBA DESA TIMUR"/>
          		<form:option value="DM04 TAMAN RIMBA DESA BARAT" label="DM04 TAMAN RIMBA DESA BARAT"/>
          		<form:option value="DM05 TAMAN WAWASAN UTARA" label="DM05 TAMAN WAWASAN UTARA"/>
          		<form:option value="DM06 TAMAN WAWASAN SELATAN" label="DM06 TAMAN WAWASAN SELATAN"/>
          		<form:option value="DM07 TAMAN WARISAN" label="DM07 TAMAN WARISAN"/>
    		    </form:select>
    		  </td>  
	         </tr> 
	         <tr>    
	          <td>Kod Lokaliti :</td>    
	          <td><form:input path="kodLokaliti" maxlength="255"/></td>  
	         </tr> 
	         <tr>    
	          <td>Lokaliti :</td>    
	          <td><form:input path="lokaliti" maxlength="500"/></td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Umur :</td>    
	           <td>
	          	<form:select path="kumpUmur">
          		<form:option value="21-29" label="21-29"/>
          		<form:option value="30-39" label="30-39"/>
          		<form:option value="40-49" label="40-49"/>
          		<form:option value="50-59" label="50-59"/>
          		<form:option value="60-69" label="60-69"/>
          		<form:option value="70 KEATAS" label="70 KEATAS"/>
    		    </form:select>
    		  </td>  
	         </tr> 
	         <tr>    
	          <td>Kumpulan Kaum :</td>    
	          <td>
	          	<form:select path="kumpKaum">
          		<form:option value="BUMIPUTRA SABAH" label="BUMIPUTRA SABAH"/>
          		<form:option value="BUMIPUTRA SARAWAK" label="BUMIPUTRA SARAWAK"/>
          		<form:option value="CINA" label="CINA"/>
          		<form:option value="INDIA" label="INDIA"/>
          		<form:option value="LAIN-LAIN" label="LAIN-LAIN"/>
          		<form:option value="MELAYU" label="MELAYU"/>
          		<form:option value="ORANG ASLI" label="ORANG ASLI"/>
    		    </form:select>
    		  </td>  
	         </tr> 
	         <tr>    
	          <td align="left">No. Telefon 1 :</td>
	          	<td><form:input path="telNo1" id="telNo1" maxlength="500" onkeyup="validate();" /></td>
	         </tr> 
	         <tr id="msg1t" style="display: none">   
	         	<td></td> 
	          	<td style="color:red;"><p id="msg1p"></p></td>
	         </tr>
	         <tr>    
	          <td>No. Telefon 2 :</td>  
	        	<td><form:input path="telNo2" id="telNo2" maxlength="200"  onkeyup="validate1();"/></td> 
	         </tr> 
	         <tr id="msg2t" style="display: none">   
	         	<td></td> 
	          	<td style="color:red;"><p id="msg2p"></p></td>
	         </tr>
	         <tr>    
	          <td>Alamat :</td>
	        <td><form:textarea path="alamat" maxlength="500" /></td>
	         </tr>
	         <tr>    
	          <td>Negeri :</td>
			   <td>
	          	<form:select path="negeri">
          		<form:option value="" label=""/>
          		<c:forEach items="${negeriL}" var="negeri">
			            <form:option value="${negeri}" label="${negeri}"/>
			    </c:forEach>
    		    </form:select>
    		   </td> 
	         </tr> 
	        <%--  <tr>    
	          <td>Alamat ST4 :</td>    
	          <td><form:textarea  path="alamatSt4" maxlength="500"/></td>  
	         </tr>  --%>
	         <tr>    
	          <td>Kategori :</td>
	          <td>
	          	<form:select path="categoryA">
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
	         </tr> 
	         <tr>    
	          <td><br></td>    
	           <td><input type="submit"  value="Simpan" /></td>
	         </tr>
	         <%-- <tr>    
	           <td><br></td>
	           <c:choose>
	           	<c:when test="${save}">
	           		 <td style="color:green;"><c:out value="Maklumat berjaya disimpan."></c:out> </td>
<!-- 	           		  <td><input type="submit" formaction="carianPengundi" formmethod="get" value="Kembali" /></td> -->
	           	</c:when>
	           	<c:when test="${save == false}">
	           		<td style="color:red;"><c:out value="Maklumat gagal disimpan."></c:out> </td>
	           	</c:when>
	           </c:choose>
	         </tr>     --%>
	         <tr>    
	          <td><br></td>    
	         </tr> 
        </table>    
       </fieldset>
        
       </form:form>    
</body>

<script >

function validate(){
	var str1, text;
	 str1 = document.getElementById("telNo1").value;
	 var x = document.getElementById("msg1t");
	if(isNaN(str1)){
		 text ="Sila masukkan nombor telefon yang betul ";
		 x.style.display = "block";
	 }else{
		 text ="";
		 x.style.display = "none";
	 }
	document.getElementById("msg1p").innerHTML = text;
}

function validate1(){
	var str1, text;
	 str1 = document.getElementById("telNo2").value;
	 var x = document.getElementById("msg2t");
	if(isNaN(str1)){
		 text ="Sila masukkan nombor telefon yang betul ";
		 x.style.display = "block";
	 }else{
		 text ="";
		 x.style.display = "none";
	 }
	document.getElementById("msg2p").innerHTML = text;
}

</script>
</html>
