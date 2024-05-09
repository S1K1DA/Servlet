<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<header>
        <!-- background image -->
        <div class="header">GREEN과 함께 행복을 찾으세요!</div>

        <!-- select box -->
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
    </header>