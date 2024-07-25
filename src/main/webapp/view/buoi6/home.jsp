<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<form action="/san-pham/search" method="get">
    Ten: <input type="text" name="tenSearch"/>
    <button type="submit">Search</button>
</form>
<form:form modelAttribute="sanPhamRequest" action="/san-pham/add1" method="post">
    MA: <form:input type="text" path="ma"/><br>
    <form:errors path="ma"/>
    Ten: <form:input type="text" path="ten"/><br>
    <form:errors path="ten"/>
    Mo ta: <form:input type="text" path="moTa"/><br>
    gia ban: <form:input type="text" path="giaBan"/><br>
    So luong: <form:input type="text" path="soLuong"/><br>
    Ma loai SP: <form:select path="loaiSP">
    <form:options items="${listLoaiSanPham}" itemValue="id" itemLabel="ten"/>
</form:select>
    <form:button type="submit">Add</form:button>
</form:form>
<table border="1">
    <%--    Ma, Ten, Mota, GiaBan, SoLuong, Mã loại SP, Tên loại SP--%>
    <thead>
    <tr>
        <th>Ma</th>
        <th>Ten</th>
        <th>Mo Ta</th>
        <th>Gia ban</th>
        <th>So Luong</th>
        <th>Ma loai sp</th>
        <th>Ten loai sp</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listSanPham.content}" var="sp">
        <tr>
            <td>${sp.ma}</td>
            <td>${sp.ten}</td>
            <td>${sp.moTa}</td>
            <td>${sp.giaBan}</td>
            <td>${sp.soLuong}</td>
            <td>${sp.loaiSP.ma}</td>
            <td>${sp.loaiSP.ten}</td>
            <td>
                <a href="/san-pham/remove1/${sp.id}">Remove</a>
                <a href="/san-pham/detail1/${sp.id}">Detail</a>
                <a href="/san-pham/view-update1/${sp.id}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav aria-label="Page navigation example">
    <ul class="pagination">
        <c:if test="${listSanPham != null && listSanPham.totalPages > 0}">
            <c:forEach begin="0" end="${listSanPham.totalPages - 1}" varStatus="loop">
                <li class="page-item">
                    <a class="page-link" href="/san-pham/hien-thi-tat-ca?page=${loop.begin + loop.count - 1}">
                            ${loop.begin + loop.count}
                    </a>
                </li>
            </c:forEach>
        </c:if>
    </ul>
</nav>
</body>
</html>