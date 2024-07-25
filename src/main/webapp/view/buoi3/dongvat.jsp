<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/dong-vat/search">
        <div class="mb-3">
            Tên:<input type="text" class="form-control" name="tenSearch"><br>
            Cân nặng Min: <input type="text" class="form-control" name="canNangMinSearch"><br>
            Cân nặng Max:<input type="text" class="form-control" name="canNangMaxSearch"><br>
        </div>
        <div class="mb-3">
            <button>Search</button>
        </div>
    </form>
</div>
<br>
<form:form modelAttribute="dv1" action="/dong-vat/add" method="post">
    Mã: <form:input type="text" class="form-control" path="ma"/>
    <form:errors path="ma"/>
    Tên: <form:input type="text" class="form-control" path="ten"/>
    <form:errors path="ten"/>
    Cân nặng: <form:input type="text" class="form-control" path="canNang"/>
    <form:errors path="canNang"/>
    Khu vực sống: <form:select path="khuVucSong">
    <form:option value="KVS1" label="KVS1"/>
    <form:option value="KVS2" label="KVS2"/>
    <form:option value="KVS3" label="KVS3"/>
    <form:option value="KVS4" label="KVS4"/>
    <form:option value="KVS5" label="KVS5"/>
</form:select>
    Giới tính: <form:radiobutton value="true" path="gioiTinh" label="Nam"/>
    <form:radiobutton value="false" path="gioiTinh" label="Nữ"/>
    <form:button>Add</form:button>
</form:form>
<%--<form action="/dong-vat/add" method="post">--%>
<%--    <div class="mb-3">--%>
<%--        <label class="form-label">Mã</label>--%>
<%--        <input type="text" class="form-control" name="ma">--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label class="form-label">Khu vực sống</label>--%>
<%--        <select class="form-select" aria-label="Default select example" name="khuVucSong">--%>
<%--            <option value="KVS1">KVS1</option>--%>
<%--            <option value="KVS2">KVS2</option>--%>
<%--            <option value="KVS3">KVS3</option>--%>
<%--            <option value="KVS4">KVS4</option>--%>
<%--            <option value="KVS5">KVS5</option>--%>
<%--        </select>--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label class="form-label">Tên</label>--%>
<%--        <input type="text" class="form-control" name="ten">--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label class="form-label">Cân nặng</label>--%>
<%--        <input type="text" class="form-control" name="canNang">--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label  class="form-label">Giới tính</label>--%>
<%--        <div class="form-check">--%>
<%--            <input class="form-check-input" type="radio" name="gioiTinh">--%>
<%--            <label class="form-check-label">--%>
<%--                Nam--%>
<%--            </label>--%>
<%--        </div>--%>
<%--        <div class="form-check">--%>
<%--            <input class="form-check-input" type="radio" name="gioiTinh" checked>--%>
<%--            <label class="form-check-label">--%>
<%--                Nữ--%>
<%--            </label>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <button>Add</button>--%>
<%--</form>--%>
<br>
<table class="table">
    <thead>
    <tr>

        <th scope="col">Mã</th>
        <th scope="col">Tên</th>
        <th scope="col">Giới tính</th>
        <th scope="col">Cân Nặng</th>
        <th scope="col">Khu vực sống</th>
        <th scope="col">Action</th>
    </tr>
    </thead>
    <tbody>
    <C:forEach items="${lists}" var="s">
        <tr>
            <td>${s.ma}</td>
            <td>${s.ten}</td>
            <td>${s.gioiTinh}</td>
            <td>${s.canNang}</td>
            <td>${s.khuVucSong}</td>
            <td>
                <a href="/dong-vat/view-update/${s.ma}">Update</a>
                <a href="/dong-vat/remove/${s.ma}">Remove</a>
                <a href="">Detail</a>
            </td>
        </tr>

    </C:forEach>
    </tbody>

</table>
</body>
</html>