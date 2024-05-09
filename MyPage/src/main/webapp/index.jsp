<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" href="/resources/css/Main.css">
	<%@ include file="views/common/head.jsp" %>
  <!--   <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Travle Page</title> -->
</head>

<!-- <link rel="stylesheet" href="./Main.css">
<link rel="stylesheet" href="./banner.css">
<link rel="stylesheet" href="./header.css">
<link rel="stylesheet" href="./footer.css">  -->

<body>

    <!-- banner -->
    <%@ include file="views/common/banner.jsp" %>
   <!--  <nav class="banner-container">
        <a href="./Main.html">
            <div class="logo"></div>
        </a>
        <a href="./Detail.html">DETAIL</a>
        2depth
        <div class="main-menu">
            <a href="">REVIEW</a>
                <div class="sub-menu">
                    <li><a href="./Review-asia.html">ASIA</a></li>
                    <li><a href="./Review-europe.html">EUROPE</a></li>
                    <li><a href="./Review-ko.html">KO</a></li>
                </div>
        </div>
            2depth

        <div class="signin">
            <a href="./login.html">로그인</a>
            <a href="./register.html">회원가입</a>
        </div>
    </nav> -->

    <!-- header -->
    <%@ include file="/views/common/header.jsp" %>
    <!-- <header>
        background image
        <div class="header">GREEN과 함께 행복을 찾으세요!</div>

        select box
        <section>
            <div class="main-box">
                <input type="text" class="where" placeholder="🇰🇷 어디로 떠나시나요?">
                <input type="number" class="people" placeholder="🎅🏻 인원을 설정해주세요.">
                <label for="start" class="start-label"> 🛫 출발일을 설정해주세요 </label>
                <input type="date" class="start" id="start">
                <label for="end" class="end-label"> 🛬 도착일을 설정해주세요 </label>
                <input type="date" class="end" id="end">
            </div>

            <button type="submit" class="btn">검색하기</button>
        </section>
    </header> -->

    <!-- Main -->
     <%@ include file="/views/common/Main.jsp" %>
    <!-- <main>
        <div class="main">
            <div class="part1">인기 여행지</div>
            <img src="./img/busan.png" alt="인기 여행지">
            <img src="./img/daegu.png" alt="인기 여행지">
            <img src="./img/china.png" alt="인기 여행지">
            <img src="./img/europe.png" alt="인기 여행지">

            <div class="part2">여행객 리뷰</div>
            <img src="./img/review.png" alt="리뷰">
            <img src="./img/review2.png" alt="리뷰">
        </div>
    </main> -->

    <!-- footer -->
    <%@ include file="/views/common/footer.jsp" %>
    <!-- <footer>
        <table class="table">
            <thead>
                <th>도움말-문의</th>
                <th>회사명</th>
                <th>여행지</th>
                <th>파트너</th>
                <th>모바일 GREEN</th>
            </thead>

            <tbody>
                <tr>
                    <td>도움말센터</td>
                    <td>회사 소개</td>
                    <td>국가별</td>
                    <td>YCS 파트너 포털</td>
                    <td>IOS</td>
                </tr>
                <tr>
                    <td>자주 묻는 질문 FAQ</td>
                    <td>채용 정보</td>
                    <td>도시별</td>
                    <td>Partner Hub</td>
                    <td>Android</td>
                </tr>
                <tr>
                    <td>개인정보 처리방침</td>
                    <td>프레스센터 / 보도자료</td>
                    <td></td>
                    <td>광고문의</td>
                    <td></td>
                </tr>
                <tr>
                    <td>쿠키 정책</td>
                    <td>블로그</td>
                    <td></td>
                    <td>제휴 파트너</td>
                    <td></td>
                </tr>
                <tr>
                    <td>이용 약관</td>
                    <td>포인트맥스</td>
                    <td></td>
                    <td>커넥티비티 파트너</td>
                    <td></td>
                </tr>
                <tr>
                    <td>쿠키 설정 관리</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td>Digital Service Act(EU)</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

        <div class="spon">
            <a href="https://flyairseoul.com/CW/ko/main.do" target="_blank"><img src="./img/airplane.svg"
                    alt="airplane"></a>
            <a href="https://www.youtube.com/" target="_blank"><img src="./img/caret-right-square-fill.svg"
                    alt="youtube"></a>
            <a href="https://www.weather.go.kr/w/index.doa" target="_blank"><img src="./img/cloud-rain-heavy-fill.svg"
                    alt="weather"></a>
            <a href="https://www.instagram.com/" target="_blank"><img src="./img/instagram.svg" alt="instagram"></a>
            <a href="https://www.threads.net/login" target="_blank"><img src="./img/threads-fill.svg" alt="threads"></a>
        </div>

    </footer> -->
</body>

</html>