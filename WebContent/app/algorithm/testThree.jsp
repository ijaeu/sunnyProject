<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3번</title>
<link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/testThree.css" />
</head>
<body>
	    <section id="qna" class="mx-auto my-5 py-5 px-3">
      <progress value="120" max="200" id="my_skill"></progress>
          <a href="http://localhost:8085/algorithm/testTwo.ag">
    <img src="../../assets/img/algorithm/뒤로가기.png" class="back">
    </a>
      <a href="http://localhost:8085/algorithm/start.ag">
      <img src="../../assets/img/algorithm/start/home.png" 
        class = "img"></a>
      <div class="questionContainer">
        <h1>3. 식물이 햇빛을 많이 볼 수 있을까요?</h1>
      </div>
      <div class="answerContainer">
        <form action="${pageContext.request.contextPath}/algorithm/testFour.ag" method="get">
		<input type="hidden"  name="selectThree" value="0">
		<input type="button"class="w-btn-outline w-btn-green2-outline"  value="집에 빛이 잘 안들어와요" onclick="document.getElementsByName('selectThree')[0].value='0';this.form.submit();"></br>
		<input type="button" class="w-btn-outline w-btn-green2-outline"value="해가 쨍쨍 들어와요" onclick="document.getElementsByName('selectThree')[0].value='1';this.form.submit();">
		</form>
		</div>
    </section>
</body>
</html>