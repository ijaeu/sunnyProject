<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>식고수페이지</title>
<link rel="stylesheet" href="${pageContent.request.contextPath}/assets/css/questionList.css">
<!-- <link rel="stylesheet" href="../css/questionList.css" /> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath}/app/header/header.jsp" />
	<div class="question-list-body">
		<div class="gosu-question-list">
			<!-- 고수닉네임과 질문페이지 안내 -->
			<div class="gosu-info"><p><strong>식고수 
				<a href="">${gosuInfo.getUserNickname() }</a></strong>
			님의 질문페이지 입니다. </p>
			</div>
			<div class="question-tip">
				<p><strong>글작성팁 !</strong> 식물에게 문제가 생기면 고수님에게 직접 도움을 요청해보세요</p>
				<img src="data:image/svg+xml;base64,PHN2ZyB3aWR0aD0iNzIiIGhlaWdodD0iNDAiIHZpZXdCb3g9IjAgMCA3MiA0MCIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgIDxnIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPHBhdGggZD0iTTQyLjY5IDBoMTUuMjI4YzEuNzU3IDAgMy40My4zNDggNC45NTEuOTc3QzY4LjIxMyAzLjAyIDcyIDguMDc0IDcyIDEzLjk5OWMwIDcuMDkyLTUuNDE4IDEzLjA2NS0xMi40NDUgMTMuOTg2LTEuMDIxLjEzNC0xLjkzNy0uNjMxLTEuOTM3LTEuNjM1di0xLjY0NUg0Mi42OWMtNy4wMDggMC0xMi42OS01LjUzLTEyLjY5LTEyLjM1M0MzMCA1LjUzMSAzNS42ODIgMCA0Mi42OSAwIiBmaWxsPSIjODBEQkI0Ii8+CiAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNDEgMTEpIiBmaWxsPSIjRkZGIj4KICAgICAgICAgICAgPGNpcmNsZSBjeD0iMiIgY3k9IjIiIHI9IjIiLz4KICAgICAgICAgICAgPGNpcmNsZSBjeD0iMTAiIGN5PSIyIiByPSIyIi8+CiAgICAgICAgICAgIDxjaXJjbGUgY3g9IjE4IiBjeT0iMiIgcj0iMiIvPgogICAgICAgIDwvZz4KICAgICAgICA8Zz4KICAgICAgICAgICAgPHBhdGggZD0iTTI5LjMxIDEySDE0LjA4MmMtMS43NTcgMC0zLjQzLjM0OC00Ljk1MS45NzdDMy43ODcgMTUuMDIgMCAyMC4wNzQgMCAyNS45OTljMCA3LjA5MiA1LjQxOCAxMy4wNjUgMTIuNDQ1IDEzLjk4NiAxLjAyMS4xMzQgMS45MzctLjYzMSAxLjkzNy0xLjYzNXYtMS42NDVIMjkuMzFjNy4wMDggMCAxMi42OS01LjUzIDEyLjY5LTEyLjM1M0M0MiAxNy41MzEgMzYuMzE4IDEyIDI5LjMxIDEyIiBmaWxsPSIjNDVDNTlCIi8+CiAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNS42NjcgMjIuMjVoLS44OWMtLjk4MSAwLTEuNzc3Ljc4My0xLjc3NyAxLjc1djUuMjVjMCAuOTY3Ljc5NiAxLjc1IDEuNzc4IDEuNzVoLjg4OWMuNDkgMCAuODg5LS4zOTIuODg5LS44NzV2LTdhLjg4Mi44ODIgMCAwIDAtLjg5LS44NzVtMTEuNTU2IDBoLTQuNDQ0bC43MzQtMi43MDZhMS43MzcgMS43MzcgMCAwIDAtLjczOC0xLjg4bC0uNzg3LS41MTdhLjg5Ny44OTcgMCAwIDAtMS4yODguMzM3bC0yLjAwNCA0LjAzOWEzLjQ1NiAzLjQ1NiAwIDAgMC0uMzYxIDEuNTM2djYuMTkxYzAgLjk2Ny43OTUgMS43NSAxLjc3NyAxLjc1aDYuMDQ0Yy44NDcgMCAxLjU3Ny0uNTg5IDEuNzQzLTEuNDA3bDEuMDY3LTUuMjVjLjIyLTEuMDgyLS42MjItMi4wOTMtMS43NDMtMi4wOTMiIGZpbGw9IiMxNTlBNkQiLz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPgo="	alt="">
			</div>
			<div class="question-list-box">
				<div class="question-name">
					<h3>질문목록</h3>
				</div>
				<div class="question-button-box">
					<ul class="anwer-btn">
						<li class="no-answer" data-questionStatus=0>답변대기</li>
						<li class="ok-answer" data-questionStatus=1>답변완료</li>
					</ul>
				</div>
				<div class="question-list">
					<!-- 반복되야하는부분 -->
					<c:choose>
						<c:when test="${not empty questionList }">
							<c:forEach var="questions" items="${questionList}">
								<div class="question">
									<div class="question-mark-box">
										<img src="../../assets/img/admin/qeustionIcon.png" alt="">
									</div>
									<div class="question-title">
										<a href="">${questions.getQuestionTitle() }</a>
									</div>
									<div class="user-profile-box">
										<a href=""><img src="${pageContext.request.contextPath}/upload/profileUpload/${questions.getFileSystemName()}" alt=""></a>
									</div>	
									<div class="user-nickname-box"><a href="">${questions.getUserNickname() }</a>
									</div>
									<div class="question-date"><p>작성시간<hr>${questions.getQuestionDate() }</p></div>
								</div>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<div>
								<p>질문이 없습니다.</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
	<script	src="${pageContent.request.contextPath}/assets/js/questionList.js"></script>
  <!-- <script src="../js/questionList.js"></script> -->
</body>
</html>

