<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">


<%@ include file="/views/common/head.jsp" %><!-- 
<link rel="stylesheet" href="/resources/css/banner.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="/resources/css/header.css"> -->
<link rel="stylesheet" href="/resources/css/login.css">


<body>
    <!-- banner -->
     <%@ include file="/views/common/banner.jsp" %>


    <div class="login-container">
        <div class="login-main">
            <h2>로그인</h2>
            <p>해당 페이지를 이용하시려면 본인 확인을 위해 다시 한 번 로그인해 주시기 바랍니다.</p>
        </div>

        <div class="login-links">
            <a class="login-email" href="./login.html">이메일</a>
            <a class="login-phone" href="./login-phone.html">휴대전화</a>
            <br>
        </div>

        <form action="/member/login.do" method="POST">
            <div class="login-box">
                <label for="email">이메일</label>
                <input type="email" id="email" name="useremail" required placeholder="이메일"><br>
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="userpassword" required placeholder="비밀번호"><br>

                <button class="login-button" onclick="login()">로그인</button>

                <a href="./register.html">
                    <span class="register">회원가입</span>
                </a>
            </div>

            <!-- 로그인, 회원가입 footer -->
            <div>
                <span>혹은 아래 계정을 이용해 로그인</span>
            </div>
            <hr>

            <div>
                <button class="google-but but" type="button">
                    <img src="https://cdn6.agoda.net/images/universal-login/google-logo-v2.svg" alt="구글">
                    <span>구글</span>
                </button>
                <button class="facebook-but but" type="button">
                    <img src="https://cdn6.agoda.net/images/universal-login/facebook-logo.svg" alt="페이스북">
                    <span>페이스북</span>
                </button>
                <button class="apple-but but" type="button">
                    <img src="https://cdn6.agoda.net/images/universal-login/apple-logo.svg" alt="애플">
                    <span>애플</span>
                </button>
            </div>
        </form>
    </div>

    <!-- </body> -->

    <!-- footer -->
    <%@ include file="/views/common/footer.jsp" %>
</body>

<!-- <script>
    function login() {
        const id = "user@naver.com";
        const pwd = "qwer1234";

        const inputId = document.getElementById('email').value;
        const inputPwd = document.getElementById('password').value;

        if (!inputId || !inputPwd) {
            alert("아이디 또는 비밀번호를 입력해주세요");
        } else if (inputId !== id || inputPwd !== pwd) {
            alert("아이디 또는 비밀번호가 틀렸습니다.");
        } else {
            alert("로그인 되었습니다.");
        }
    }
</script> -->

</html>