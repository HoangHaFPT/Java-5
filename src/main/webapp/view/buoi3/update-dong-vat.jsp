<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="dv" action="/dong-vat/update/${dv.ma}" method="post">
    Mã: <form:input type="text" class="form-control" path="ma" value="${dv.ma}"/>
    <form:errors path="ma"/>
    Tên: <form:input type="text" class="form-control" path="ten" value="${dv.ten}"/>
    <form:errors path="ten"/>
    Cân nặng: <form:input type="text" class="form-control" path="canNang" value="${dv.canNang}"/>
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
    <form:button>Update</form:button>
</form:form>
<%--<form action="/dong-vat/update/${dv.ma}" method="post">--%>
<%--    <div class="mb-3">--%>
<%--        <label for="ma" class="form-label">Mã</label>--%>
<%--        <input type="text" class="form-control" id="ma" name="ma" value="${dv.ma}">--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label for="ma" class="form-label">Khu vực sống</label>--%>
<%--        <select class="form-select" aria-label="Default select example" name="khuVucSong">--%>
<%--            <option value="KVS1" ${dv.khuVucSong == "KVS1" ? "selected" : ""}>KVS1</option>--%>
<%--            <option value="KVS2" ${dv.khuVucSong == "KVS2" ? "selected" : ""}>KVS2</option>--%>
<%--            <option value="KVS3" ${dv.khuVucSong == "KVS3" ? "selected" : ""}>KVS3</option>--%>
<%--            <option value="KVS4" ${dv.khuVucSong == "KVS4" ? "selected" : ""}>KVS4</option>--%>
<%--            <option value="KVS5" ${dv.khuVucSong == "KVS5" ? "selected" : ""}>KVS5</option>--%>
<%--        </select>--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label for="ten" class="form-label">Tên</label>--%>
<%--        <input type="text" class="form-control" id="ten" name="ten" value="${dv.ten}">--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label for="canNang" class="form-label">Cân nặng</label>--%>
<%--        <input type="text" class="form-control" id="canNang" name="canNang" value="${dv.canNang}">--%>
<%--    </div>--%>
<%--    <div class="mb-3">--%>
<%--        <label  class="form-label">Giới tính</label>--%>
<%--        <div class="form-check">--%>
<%--            <input class="form-check-input" type="radio" value="true" name="gioiTinh" ${dv.gioiTinh == true ? "checked" : ""}>--%>
<%--            <label class="form-check-label">--%>
<%--                Nam--%>
<%--            </label>--%>
<%--        </div>--%>
<%--        <div class="form-check">--%>
<%--            <input class="form-check-input" type="radio" value="false" name="gioiTinh" ${dv.gioiTinh == false ? "checked" : ""}>--%>
<%--            <label class="form-check-label">--%>
<%--                Nữ--%>
<%--            </label>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <button>Update</button>--%>
<%--</form>--%>
</body>
</html>