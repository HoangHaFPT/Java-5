<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Mã Sach, Tên Sach, Số Trang, Đơn giá, Tên NXB, Ma NXB.--%>
<form action="/sach/add" method="post">
    Ma sach: <input type="text" name="ma" value="${s.ma}"/>
    <br>
    Ten sach: <input type="text" name="ten" value="${s.ten}"/>
    <br/>
    So trang: <input type="text" name="soTrang" value="${s.soTrang}"/>
    <br/>
    Don gia: <input type="text" name="donGia" value="${s.donGia}"/>
    <br/>
    Nha xuat ban:
    <select name="nxb">
        <c:forEach items="${listNXB}" var="nxb">
            <option value="${nxb.id}" ${s.nxb.id == nxb.id ? "selected" : ""}>${nxb.ten1}</option>
        </c:forEach>
    </select>
    <br/>
    <button type="submit" class="btn btn-primary">Add</button>
    <br>
</form>
<table class="table">
    <thead>
    <tr>
        <th>Ma sach</th>
        <th scope="col">Ten sach</th>
        <th scope="col">So trang</th>
        <th scope="col">Don gia</th>
        <th scope="col">Ma NXB</th>
        <th scope="col">Ten NXB</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${lists}" var="sach">
        <tr>
            <th>${sach.id}</th>
            <td>${sach.ten}</td>
            <td>${sach.soTrang}</td>
            <td>${sach.donGia}</td>
            <td>${sach.nxb.ma1}</td>
            <td>${sach.nxb.ten1}</td>
            <td>
                <a href="/sach/detail/${sach.id}">Detail</a>
                <a href="/sach/remove/${sach.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>