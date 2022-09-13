<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book FORM</title>
    <!--    STYLESHEETS-->
    <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/css/bootstrap-select.min.css">

    <%--    SCRIPTS     --%>
    <script src="/webjars/jquery/3.6.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.14.0-beta2/js/bootstrap-select.min.js"></script>


</head>
<body>


<div class="container text-center">

    <h1>======= ADD NEW BOOK ========</h1>

    <div class="row">
        <div class="col-md-6 offset-3">
            <form action="/books" method="post">

                <div class="mb-3">
                    <label for="bookTitle" class="form-label">Title</label>
                    <input name="title" type="text" class="form-control" id="bookTitle">
                </div>

                <div class="mb-3">
                    <label for="exampleInputPassword">Description</label>
                    <textarea class="form-control" id="exampleInputPassword" name="description" rows="5" cols="25"></textarea>
                </div>

                <div class="mb-3">
                    <label for="bookTotalCount" class="form-label">Total Count</label>
                    <input name="total_count" type="number" class="form-control" id="bookTotalCount">
                </div>
                <div class="mb-3">
                    <label for="isbn" class="form-label">ISBN</label>
                    <input name="isbn" type="text" class="form-control" id="isbn">
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
                            <option value="${val.authorId}">${val.authorFullName}</option>
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
                            <option value="${val.categoryIds}">${val.categoryName}</option>
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
                            <option value="${val.languageIds}">${val.lang}</option>
                        </c:forEach>
                    </select>
                </div>


                <button type="submit" class="btn btn-primary">Saqlash</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
