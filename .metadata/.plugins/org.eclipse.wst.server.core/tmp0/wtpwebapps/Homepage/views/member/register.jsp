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
    <div class="signup-form">
        <h2>회원가입</h2>
        <form action="/member/register.do" method="POST">
          <div class="input-container">
        </div>
        <div class="input-container">
          <label for="new-username">이름:</label>
          <input type="text" id="new-username" name="new-username" required>
        </div>

        <div class="input-container">
            <label for="new-userid">아이디:</label>
            <input type="text" id="new-userid" name="new-userid" required>
        </div>
          <div class="input-container">
            <label for="new-password">비밀번호:</label>
            <input type="password" id="new-password" name="new-password" required>
          </div>
  
          <div class="input-container">
            <label for="confirm-password">비밀번호 확인:</label>
            <input type="password" id="confirm-password" name="confirm-password" required>
          </div>
  
          <button type="submit">회원가입</button>
        </form>
      </div>
  </section>

    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>