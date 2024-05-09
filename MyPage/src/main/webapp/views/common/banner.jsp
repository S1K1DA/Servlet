<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <nav class="banner-container">
        <a href="./Main.html">
            <div class="logo"></div>
        </a>
        <a href="./Detail.html">DETAIL</a>
        <!-- 2depth -->
        <div class="main-menu">
            <a href="">REVIEW</a>
                <div class="sub-menu">
                    <li><a href="./Review-asia.html">ASIA</a></li>
                    <li><a href="./Review-europe.html">EUROPE</a></li>
                    <li><a href="./Review-ko.html">KO</a></li>
                </div>
        </div>
            <!-- 2depth -->

        <div class="signin">
            <a href="/form/loginForm.do">로그인</a>
            <a href="/form/registerForm.do">회원가입</a>
        </div>
    </nav>