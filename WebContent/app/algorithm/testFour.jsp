<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>4번</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/testFour.css" />
</head>
<body>
	<section id="qna" class="mx-auto my-5 py-5 px-3">
      <progress value="160" max="200" id="my_skill"></progress>
          <a href="http://localhost:8085/algorithm/testThree.ag">
    <img src="../../assets/img/algorithm/뒤로가기.png" class="back">
    </a>
      <a href="http://localhost:8085/algorithm/start.ag">
      <img src="../../assets/img/algorithm/start/home.png" 
        class = "img"></a>
      <div class="questionContainer">
        <a href="http://127.0.0.1:5500/html/FindMyPlant/test3/test3.html">
        </a>
        <h1>4. 내가 원하는 식물 스타일은?</h1>
      </div>
      <div class="answerContainer">
        	<form action="${pageContext.request.contextPath}/algorithm/testFive.ag" method="get">
		<input type="hidden" name="selectFour" value="0">
		<input type="button" class="w-btn-outline w-btn-green2-outline"  value="무난하고 푸릇푸릇" onclick="document.getElementsByName('selectFour')[0].value='0';this.form.submit();"></br>
		<input type="button"  class="w-btn-outline w-btn-green2-outline" value="이왕이면 화려한 무늬" onclick="document.getElementsByName('selectFour')[0].value='1';this.form.submit();">
	</form>
      </div>
    </section>
</body>
</html>