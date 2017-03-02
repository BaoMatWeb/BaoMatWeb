<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<html>
<head>
<title>SELECT Operation</title>
</head>
<body>

<c:if test="${ empty param.Email or empty param.password}">
	 <c:redirect url="loginPage.jsp" >
              <c:param name="errMsg" value="Điền Email và mật khẩu !!!" />
      </c:redirect>
</c:if>

<c:if test="${not empty param.Email and not empty param.password}">
      <sql:setDataSource var="ds" driver="com.mysql.jdbc.Driver"
                       url="jdbc:mysql://localhost:3306/db_webnckh"
                       user="root" password="123456"/>
 
      <sql:query dataSource="${ds}" var="loginTable">
        select count(*) as kount from taikhoan
        where email='${param.Email}'
        and matkhau='${param.password}' and quyen='${param.phanquyen}'
      </sql:query>
 
      <c:forEach items="${loginTable.rows}" var="row">
        <c:choose>
          <c:when test="${row.kount gt 0}">
            <c:set scope="session"
                   var="Email"
                   value="${param.Email}"
                  />
              	<c:choose>
         			 <c:when test="${param.phanquyen eq 'Student' }">   
         			 	<c:redirect url="sinhvienPage.jsp"/>
         			 </c:when>
         			 <c:when test="${param.phanquyen eq 'Lecturers' }">   
         			 	<c:redirect url="giangvienPage.jsp"/>
         			 </c:when>
         			 <c:when test="${param.phanquyen eq 'Manager' }">   
         			 	<c:redirect url="quanlyPage.jsp"/>
         			 </c:when>
         			 <c:when test="${param.phanquyen eq 'Admin' }">   
         			 	<c:redirect url="Admin.jsp"/>
         			 </c:when>
         			 <c:otherwise>
			            <c:redirect url="loginPage.jsp" >
			              <c:param name="errMsg" value="Chọn phân quyền sai!!" />
			            </c:redirect>
			          </c:otherwise>
         		</c:choose>
          </c:when>
          <c:otherwise>
            <c:redirect url="loginPage.jsp" >
              <c:param name="errMsg" value="Mật khẩu hay tài khoản hay phân quyền không đúng !!!" />
            </c:redirect>
          </c:otherwise>
        </c:choose>
 
      </c:forEach>
 
  </c:if>

</body>
</html>
