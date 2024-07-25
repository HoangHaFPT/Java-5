<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<form:form modelAttribute="sp" method="post" action="/san-pham/update/${sp.ma}">
    ID: <form:input type="text" path="id" value="${sp.id}"/>
    <form:errors path="id" />
    Ma: <form:input type="text" path="ma" value="${sp.ma}"/>
    <form:errors path="ma" />
    Ten: <form:input type="text" path="ten" value="${sp.ten}"/>
    <form:errors path="ten"/>
    Gia: <form:input type="text" path="gia" value="${sp.gia}"/>
    <form:errors path="gia"/>
    Loai:<form:select path="loai">
    <form:option value="van phong" label="VP"/>
    <form:option value="van phong 1" label="VP1"/>
    <form:option value="van phong 2" label="VP2"/>
    <form:option value="van phong 3" label="VP3"/>
    <form:option value="van phong 4" label="VP4"/>
</form:select>
    <form:errors path="loai"/>

    <form:button type="submit">Update</form:button>
</form:form>
</body>
</html>