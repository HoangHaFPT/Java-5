<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Document</title>
</head>
<body>
<form:form modelAttribute="sp" action="/san-pham/update1/${sp.id}" method="post">
    MA: <form:input type="text" path="ma" value="${sp.ma}"/><br>
    <form:errors path="ma"/>
    Ten: <form:input type="text" path="ten" value="${sp.ten}"/><br>
    <form:errors path="ten"/>
    Mo ta: <form:input type="text" path="moTa" value="${sp.moTa}"/><br>
    gia ban: <form:input type="text" path="giaBan" value="${sp.giaBan}"/><br>
    So luong: <form:input type="text" path="soLuong" value="${sp.soLuong}"/><br>
    Ma loai SP: <form:select path="loaiSP">
    <form:options items="${listLoaiSanPham}" itemValue="id" itemLabel="ten"/>
</form:select>
    <form:button type="submit">Update</form:button>
</form:form>
</body>
</html>