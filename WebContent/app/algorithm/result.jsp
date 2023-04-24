<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과페이지</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/result.css">
</head>
<body>
<section id="result">
<div class="result-name">${result.plantName}</div>
<div class="result-profile">여기에 프로필 사진 넣어야함</div>
  <ul class="content">
    <li>${result.plantContent}</li>
  </ul>
    <div class="result-tip" >
      <h6>💖 알아두면 좋은 TIP!
        <ul class="sub-content">
          <li>물을 조금씩 자주 주면 과습의 원인이 될 수 있어요</br>
          흙이 말랐을 때 밑에 물이 빠질 정도로 흠뻑 주세요! </li>           
          <li>갑자기 잎이 노래지거나 줄기만 보기 싫게 자랐나요?</br></li>
          빛이 부족해서 그럴 수 있어요! 밝은 곳으로 옮겨 주세요</li>
        </ul>
      </h6>
      <button type="btn" class="btn1"onclick="location.href= 'http://localhost:8085/algorithm/start.ag';">다시하기</button>
      <button type="btn" class="btn1"onclick="location.href= 'http://localhost:8085/main/mainOk.ma';">홈페이지</button>
    </div>
    </div>
  </section>
<!--   <script type="text/javascript"></script> -->
</body>
</html> 