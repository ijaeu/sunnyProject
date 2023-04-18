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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/userDrop.css" />
  </head>
  <body>
  <jsp:include page="${pageContext.request.contextPath}/app/header/header.jsp"/>
    <div class="container">
      <section class="top">
        <h1>회원탈퇴</h1>
        <p>볕 들 무렵 서비스를 이용해 주셔서 감사합니다.</p>
      </section>
      <section class="bottom">
        <div class="info">
          <p>탈퇴를 하시면</p>
          <p>
            볕 들 무렵에서 이용하신 모든 회원정보(게시물 등)가 삭제되며, 더 이상
            서비스를 이용할 수 없게 됩니다.<br />
            또한 삭제된 정보는 복구할 수 없습니다. <br />
            * 회원 탈퇴 시 동일 이메일로 재가입이 불가합니다.
          </p>
        </div>
        <div class="form">
          <!-- form태그 처리 -->
          <form action="${pageContext.request.contextPath}/user/userDropOk.us" method="POST">
            <!-- 다시 마이페이지로 이동 -->
            <a href="${pageContext.request.contextPath}/user/myPageOk.us">서비스 계속 이용하기</a>
            <!-- 탈퇴처리 -->
            <button type="submit" class="user-drop-btn">탈퇴하기</button>
          </form>
        </div>
      </section>
    </div>
    <jsp:include page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/assets/js/userDrop.js"></script>
  </body>
</html>
    