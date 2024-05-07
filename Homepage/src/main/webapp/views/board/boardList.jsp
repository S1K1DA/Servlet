<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 	<%@ include file="/views/common/head.jsp" %>
</head>
<body>
    <%@ include file="/views/common/header.jsp" %>	

 	<%@ include file="/views/common/nav.jsp" %>

       <section>
        <div class="table-container">
            <table>
                <tr>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>내용</th>
                </tr>
                <tr>
                    <td>게시물 제목 1</td>
                    <td>글쓴이 1</td>
                    <td>이곳에 게시물 내용이 들어갑니다.</td>
                </tr>
                <tr>
                    <td>게시물 제목 2</td>
                    <td>글쓴이 2</td>
                    <td>이곳에 게시물 내용이 들어갑니다.</td>
                </tr>
            </table>
            <button class="add-button" onclick="window.location.href = 'enrollForm.html'">등록</button>
        </div>
  </section>

    <%@ include file=/views/common/footer.jsp %>
</body>
</html>