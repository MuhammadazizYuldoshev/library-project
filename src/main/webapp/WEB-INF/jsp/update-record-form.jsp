<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/13/2022
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UPDATE RECORD FORM</title>
</head>
<body>

<h1 style="text-align: center">UPDATE RECORD</h1>
<link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-md-6 offset-3">
        <form action="/records/update" method="post">

            <div class="form-group">
                <label for="booksIds">Books:</label>
                <select id="booksIds"
                        class="selectpicker form-control"
                        multiple
                        aria-label="Please select books"
                        data-live-search="true"
                        name="booksId"
                        required
                >
                    <c:forEach items="${bookList}" var="book">
                        <c:choose>
                            <c:when test="${record.bookList.contains(book)}">
                                <option selected value="${book.id}">${book.title}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${book.id}">${book.title}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>

            <div class="form-group">

                <label for="userId">User:</label>
                <select id="userId"
                        class="selectpicker form-control"
                        aria-label="Please select user"
                        data-live-search="true"
                        name="userId"
                        required
                >
                    <c:forEach items="${userDtoList}" var="user">
                        <c:choose>
                            <c:when test="${record.userId == user.id}">
                                <option selected value="${user.id}">${user.fullName}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${user.id}">${user.fullName}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>


            <br>
            <button type="submit" class="btn btn-primary">UPDATE</button>
        </form>
    </div>
</div>
</div>

</body>
</html>
