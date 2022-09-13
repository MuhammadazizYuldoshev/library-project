<%--
  Created by IntelliJ IDEA.
  User: Muhammadaziz
  Date: 9/11/2022
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UPDATE BOOK</title>
    <!--    STYLESHEETS-->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">

    <%--    SCRIPTS     --%>
    <script src="${pageContext.request.contextPath}/webjars/jquery/3.6.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>
</head>
<body>

<div class="container text-center">

    <h1>UPDATE BOOK</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/books/update-book" method="post">

                <input type="hidden" name="id" value="${book.id}">
                <div class="mb-3">
                    <label for="bookTitle" class="form-label">Title</label>
                    <input name="title" type="text" class="form-control" id="bookTitle" value="${book.title}">
                </div>

                <div class="form-group">
                    <label for="exampleInputPassword">Description</label>
                    <textarea class="form-control" id="exampleInputPassword" rows="10" cols="45"  name="description">${book.description}</textarea>

                </div>

                <div class="mb-3">
                    <label for="bookTotalCount" class="form-label">Total Count</label>
                    <input name="total_count" type="number" class="form-control" id="bookTotalCount"
                           value="${book.total_count}">
                </div>
                <div class="mb-3">
                    <label for="isbn" class="form-label">ISBN</label>
                    <input name="isbn" type="text" class="form-control" id="isbn" value="${book.isbn}">
                </div>


                <div class="form-group">
                    <label for="authorsIds">Authors:</label>
                    <select id="authorsIds"
                            class="selectpicker form-control"
                            multiple
                            aria-label="Please select authors"
                            data-live-search="true"
                            name="authorsIds">
                        <c:forEach items="${authorList}" var="val">
                            <c:choose>
                                <c:when test="${book.authorDtoList.contains(val)}">
                                    <option selected value="${val.authorId}">${val.authorFullName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${val.authorId}">${val.authorFullName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="CategoryIds">Category:</label>
                    <select id="CategoryIds"
                            class="selectpicker form-control"
                            multiple
                            aria-label="Please select categories"
                            data-live-search="true"
                            name="categoryIds">
                        <c:forEach items="${categoryList}" var="val">
                            <c:choose>
                                <c:when test="${book.categoryList.contains(val)}">
                                    <option selected value="${val.categoryIds}">${val.categoryName}</option>
                                </c:when>
                                <c:otherwise>
                                    <option  value="${val.categoryIds}">${val.categoryName}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="Language">Language:</label>
                    <select id="Language"
                            class="selectpicker form-control"
                            aria-label="Please select categories"
                            name="language_id">
                        <c:forEach items="${languageList}" var="val">
                            <c:choose>
                                <c:when test="${book.language_id==val.languageIds}">
                                    <option selected value="${val.languageIds}">${val.lang}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${val.languageIds}">${val.lang}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>


                <button type="submit" class="btn btn-primary">UPDATE</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>
