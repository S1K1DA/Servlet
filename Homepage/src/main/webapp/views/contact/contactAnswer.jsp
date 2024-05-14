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

<section class="container mt-4" style="height: 70vh">
    <div class="card text-center" style="height: 100%">
        <div class="card-header">
            <h2 id="fb-title">연락 답변하기</h2>
        </div>
        <div class="card-body">
            <div class="d-flex justify-content-center mb-3">
                <div class="mx-3">작성자: <span id="fb-writer">홍길동</span></div>
                <div class="mx-3">이메일: <span id="fb-views">test@test.com</span></div>
                <div class="mx-3">작성일: <span id="fb-date">2024-05-03</span></div>
            </div>
            <hr> 
            <div style="margin-top:20px; margin-bottom: 20px;">
              <div>
                <p class="card-text" style="height: 200px;">
                    문의 내용
                </p>
              </div>
                <hr>
              <textarea name="" id="" style="height: 200px;">이곳에 답변 내용을 입력하세요.</textarea>
            </div>
        </div>
        <div class="card-footer d-flex justify-content-center">
            <button class="btn btn-secondary mx-2" onclick="window.history.back()">뒤로가기</button>
            <button class="btn btn-primary mx-2">등록</button>
        </div>
    </div>
</section>

    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>