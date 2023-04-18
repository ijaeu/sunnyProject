<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/userModify.css" />
  </head>
  <body>
  <jsp:include page="${pageContext.request.contextPath}/app/header/header.jsp"/>
    <div class="container">
      <section class="top">
        <h1>회원정보수정</h1>
      </section>
      <section class="bottom">
        <div class="user-info">
          <!-- 회원정보 수정 form 경로처리 -->
          <!-- 정보 받아와서 모두 꽂아넣는다 비밀번호 빼고 -->
          
          <form action="${pageContext.request.contextPath}/user/userModifyOk.us" method="POST">
            <!-- 받아올 아이디 수정불가 -->
            <div class="title user-id">
              <p>아이디</p>
              <div class="content">
                <p><c:out value="${userInfo.getUserId()}" /></p>
              </div>
            </div>
            <div class="title user-password">
              <p>현재 비밀번호</p>
              <div class="content">
              	<input type="password" name="currentPassword"
					id="current-password"  placeholder="비밀번호를 입력하세요"
					required />
					<p class="check-msg" id="check-cupw-msg"></p>
              </div>
            </div>
            <div class="title user-password">
              <p>변경 비밀번호</p>
              <div class="content">
                <input type="password"
					id="user-password" name="userPassword" placeholder="비밀번호를 입력하세요"
					required /> 
					<p class="check-msg" id="check-pw-msg"></p>
              </div>
            </div>
            <div class="title user-password">
              <p>비밀번호 확인</p>
              <div class="content">
                <input type="password"
					id="check-user-password" name="checkUserPassword" placeholder="비밀번호를 입력하세요"
					required /> 
					<p class="check-msg" id="check-chpw-msg"></p>
              </div>
            </div>
            <!-- 받아올 이름 수정불가 -->
            <div class="title user-name">
              <p>이름</p>
              <div class="content">
                <p><c:out value="${userInfo.getUserName()}" /></p>
              </div>
            </div>
            <div class="title user-nickname">
              <p>닉네임</p>
              <div class="content">
                <input type="text" value="${userInfo.getUserNickname()}" name="userNickname" id="user-nickname"/>
                <p class="check-msg" id="check-nickname-msg"></p>
              </div>
            </div>
            <div class="title user-phone-number">
              <p>연락처</p>
              <div class="content">
                <input type="text" value="${userInfo.getUserPhone()}" name="userPhone"/>
              </div>
            </div>
            <div class="title user-email">
              <p>이메일</p>
              <div class="content">
                <input type="email" value="${userInfo.getUserEmail()}" name="userEmail"/>
              </div>
            </div>
            <div class="title user-password-question">
              <p>비밀번호 찾기 질문</p>
              <div class="content">
                <select name="findQuestionNumber" id="">
                  <option value="1">가장 좋아하는 색깔은?</option>
                  <option value="2">가장 좋아하는 계절은?</option>
                  <option value="3">가장 소중한 것은?</option>
                </select>
              </div>
            </div>
            <div class="title user-password-answer">
              <p>비밀번호 찾기 답변</p>
              <div class="content">
                <input type="text" value="${userInfo.getFindPasswordAnswer()}" name="findPasswordAnswer"/>
              </div>
            </div>
            <div class="btn">
              <!-- 마이페이지로 이동 -->
              <button type="button" class="modify-cancel-btn">취소</button>
              <button type="button" class="modify-submit-btn">저장</button>
            </div>
          </form>
        </div>
      </section>
    </div>
    <jsp:include page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
    <script>let userNumber = ${userInfo.getUserNumber()}</script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/userModify.js"></script>
  </body>
</html>
