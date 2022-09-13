<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/11/2022
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BOOK DESCRIPTION</title>
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<h1 style="text-align: center; color: blue">BOOK DESCRIPTION</h1>
<p style="color: black;font-size: 25px; text-align: center">
    ${book.description}
</p>

</body>
</html>
