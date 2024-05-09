<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<%@ include file="/views/common/head.jsp" %>

<link rel="stylesheet" href="/resources/css/register.css">



<body>
    <!-- banner -->
    <%@ include file="/views/common/banner.jsp" %>
    <div>
        <div class="login-container">
            <h2>회원가입</h2>
            <br>
            <form action="/member/register.do" method="POST">
                <label for="text">영문 이름(First Name)</label>
                <input class="register-input" type="text" id="text" name="new-firstname" required placeholder="영문 이름(First Name)"><br>

                <label for="text">영문 성(Last Name)</label>
                <input class="register-input" type="text" id="text" name="new-lastname" required placeholder="영문 성(Last Name)"><br>

                <label for="email">이메일</label>
                <input class="register-input" type="email" id="email" name="new-email" required placeholder="email"><br>

                <label for="password">비밀번호</label>
                <input class="register-input" type="password" id="password" name="new-password" required placeholder="비밀번호"><br>

                <label for="password">비밀번호 확인</label>
                <input class="register-input" type="password" id="password" name="confirm-password" required placeholder="비밀번호 확인"><br>

                <!-- 개인정보처리방침 -->

                <div>
                    <hr>
                    <div>
                        <span>개인정보 처리방침</span>
                        <p>본 예약의 처리를 위해 모든 개인정보 처리방침에 동의해 주시기 바랍니다.</p>
                    </div>
                    <div class="checkbox-list">
                        <div>
                            <label class="select-all">
                                <input type="checkbox" onclick="">
                                <span>본인은 아래의 모든 개인정보 처리방침에 동의합니다.</span>
                            </label>
                        </div>
                        <div>
                            <label class="select">
                                <input type="checkbox">
                                <span class="txt"><a href="">본인은 본 서비스 약관에 동의하며 액18세 이상임을 확인합니다.[필수]</a></span>
                            </label>
                        </div>
                        <div>
                            <label class="select">
                                <input type="checkbox">
                                <span class="txt"><a href="">본인은 개인정보 처리방침에 따라 본인의 개인 정보를 사용하고 수집하는 것에
                                        동의합니다.[필수]</a></span>
                            </label>
                        </div>
                        <div>
                            <label class="select">
                                <input type="checkbox">
                                <span class="txt"><a href="">본인은 개인정보 처리방침에 따라 대한민국 또는 해외에 있는 제3자 본인의 개인 정보를 제공하는 것에
                                        동의합니다.[필수]</a></span>
                            </label>
                        </div>
                    </div>
                    <button class="register-but">회원가입</button>
                    <!-- 로그인, 회원가입 footer -->
                    <hr>
                    <div>
                        <span>다른 방법으로 로그인</span>
                    </div>
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
                        <button class="green-but" typr="button" onclick="location.href='login.html'"">그린 회원이신가요? 로그인</button>
                    </div>
            </form>
        </div>
    </div>
<!-- </body> -->
<!-- footer -->
 <%@ include file="/views/common/footer.jsp" %>

</body>

<!-- <script>
function namecheck() {
    const inputemamil = document.getElementById("email").value;
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]{2,}$/;

    if(emailPattern.test(inputemamil)) {
        alert = "사용 가능";
    } else {
        alert = "사용 불가능 이메일";
    }
    
}

</script> -->

</html>