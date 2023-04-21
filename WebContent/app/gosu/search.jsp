<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <title>식고수찾기</title>
      <link rel="stylesheet" href="../css/search2.css">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>

    <body>
      <jsp:include page="${pageContext.request.contextPath}/app/header/header.jsp" />
      <section class="pcontainer">
        <div class="ex-search">
          <h3>우리집 반려식물을 도와줄 식고수를 찾아보세요!</h3>
          <!-- 검색 -->
          <div class="headsearch">
            <form action="" class="expertsearch">
              <input type="text" placeholder="분야를 입력해 식고수 찾기" class="search-text" name="keyword" id="keyword" />
              <button class="s-btn" id="s-btn">검색</button>
            </form>
          </div>
        </div>
        <!-- 하단 -->
        <!-- 식고수들 -->
        <c:forEach var="search" items="${gosus}">
          <div class="search">
            <!-- 고수 프로필사진 + 닉네임 + 팔로우 -->
            <div class="profile">
              <a href="#">
                <div class="profile-photo">
                  <img src="" alt="">
                </div>
                <div class="expertname">식고수
                  <c:out value="${search.getUserNickname()}" />
                </div>
              </a>

              <div class="follow-btn">
                <!-- 내가 팔로우하고 있으면 팔로잉으로 띄움 -->
                <button type="button" class="user-follow">팔로우</button>
              </div>
            </div>
            <!-- 소개랑 분야 -->
            <div class="container">
              <div class="info">
                
                <p class="gosu-introduction">"<span>안녕하세요<c:out value="${search.getUserComment()}" /></span>"
                  
                </p>
                <p class="info-gosu gosu-majorname">
                 식고수 <span class="gosu-name">홍길동<c:out value="${search.getUserNickname()}" /></span>님에게
                </p>
                <p class="info-gosu">
                  <span class="gosu-field"><c:out value="${search.getGosuFields()}" />칼라데아</span> 키우는 법을 질문하세요!
                </p>
                
              </div>
              <div class="write-btn-wrap">
                <!-- 더보기 페이지 -->
                <a href="${pageContext.request.contextPath}/question/questionListOk.qs?gosuNumber=${search.getGosuNumber()}"
                  class="plus-btn" onclick="questionList()">더보기</a>
              </div>
            </div>

          </div>
        </c:forEach>
      </section>
      <jsp:include page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
      <script src="../js/search2.js"></script>
    </body>

    </html>