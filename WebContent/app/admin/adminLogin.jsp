<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>login</title>
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="../../assets/css/adminLogin.css" />
  </head>
  <body>
    <div class="container">
      <form action="loginOk.ad" method="post">
        <div class="loginPageMainName">
          <h2>관리자 로그인</h2>
        </div>
        <label for="id"><b>ID</b></label>
        <input
          type="text"
          placeholder="아이디를 입력하세요"
          name="adminId" 
          required
        />
        <label for="password"><b>Password</b></label>
        <input
          type="password"
          placeholder="비밀번호를 입력하세요"
          name="adminPassword"
          required
        />
        <button type="submit">로그인</button>
        <p class="teamName">&copy; CodeFactory</p>
      </form>
    </div>
    <script src="/assets/js/adminLogin.js"></script>
  </body>
</html>
