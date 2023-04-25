<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>볕 들 질문 | 볕 들 무렵</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/questionRead.css" />
</head>
<body>
	<!-- header -->
	<jsp:include
		page="${pageContext.request.contextPath}/app/header/header.jsp" />
	<div class="question-read-all">
		<div class="question-read">
			<div class="question-top">
				<div class="question-title-box">
					<h1 class="question-title">${question.getQuestionTitle() }</h1>
				</div>
				<div class="title-info">
					<div class="user-info">
						<div class="user-profile-img-box">
							<a
								href="/user/myPageOk.us?userNumber=${question.getUserNumber() }">
								<c:choose>
									<c:when test="${empty question.getProfileSystemName() }">
										<img
											src="${pageContext.request.contextPath}/assets/img/myPage/logo.png"
											alt="">
									</c:when>
									<c:otherwise>
										<img
											src="${pageContext.request.contextPath}/upload/profileUpload/${question.getProfileSystemName()}"
											alt="">
									</c:otherwise>
								</c:choose>
							</a>
						</div>
						<div class="user-nickname">
							<a
								href="/user/myPageOk.us?userNumber=${question.getUserNumber() }">${question.getUserNickname() }</a>
						</div>
						<c:if test="${question.getUserNumber() ne userNumber}">
						<c:if test="${question.getFollowingStatus() == 0 }">
							<button type="button" class="p1 follow dir"
								data-userNumber="${question.getUserNumber()}">팔로우</button>
						</c:if>
						<c:if test="${question.getFollowingStatus() == 1 }">
							<button type="button" class="p1 follow dir following"
								data-userNumber="${question.getUserNumber()}">팔로잉</button>
						</c:if>
						</c:if>
					</div>
					<div class="question-info">
						<div class="check-count">
							<span class="hit">조회수 : </span> <span id="hits-count"
								class="hit-count">${question.getQuestionViewcnt()}</span>
						</div>
						<div class="question-date">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성일
							<hr>
							${question.getQuestionDate()}
						</div>
					</div>
				</div>
			</div>
			<div class="question-content-box">
				<div class="question-img-box">
					<c:if test="${not empty question.getFileSystemName()}">
						<img
							src="${pageContext.request.contextPath}/upload/questionUpload/${question.getFileSystemName()}"
							alt="">
					</c:if>
				</div>
				<div class="question-content">
					${question.getQuestionContent()}</div>
			</div>
			<div class="btn-groups">
				<button type="button" class="list-btn"
					data-questionNumber="${question.getQuestionNumber()}"
					data-gosuNumber="${question.getGosuNumber() }"
					>목록</button>
				<c:if test="${sessionScope.userNumber == question.getUserNumber()}">
					<button type="button" class="modify-btn">수정</button>
					<button type="button" class="delete-btn" id="delete-btn">삭제</button>
				</c:if>
				<c:if test="${sessionScope.userNumber == question.getGosuNumber()}"></c:if>
			</div>
		</div>
		<!-- 댓글 -->
		<div class="question-reply">
			<div class="comment-form">
				<div class="holder">
					<h3 class="subtit">
						댓글 <span class="fc1" id="comment-count"></span>
					</h3>
				</div>
				<form id="comment-form">
					<input type="hidden" name="questionNumber"
						value="${question.getQuestionNumber()}" />
					<div class="form-group">
						<textarea name="content" id="content" placeholder="댓글 내용을 입력하세요." minlength="2"></textarea>
					</div>
					<div class="reply-submit">
						<button type="button" class="submit-btn">작성</button>
					</div>	
				</form>
			</div>
			<div class="comment-list">
				<!-- <ul id="comment-list">
					<li>
						<div class="comment-info">
							<span class="user-profile-img-box"> <img src="../img/sogum.jpg" alt=""></span> 
							<span class="writer"><a href="">샘플홍길동</a></span> <span class="date">2222-22-22</span>
						</div>
						<div class="comment-content-wrap">
							<div class="comment-content">
								<p>안녕하세요</p>
							</div>
							<div class="comment-btn-group">
								<button type="button" class="comment-modify-ready">수정</button>
								<button type="button" class="comment-delete">삭제</button>
							</div>
							<div class="comment-btn-group none">
								<button type="button" class="comment-modify">수정 완료</button>
							</div>
						</div>
					</li>
				</ul> -->
			</div>
		</div>
	</div>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
	<script>
		let userNumber = "${sessionScope.userNumber}";
	</script>
	<script>
		let gosuNumber = "${question.getGosuNumber()}";
	</script>
	<script>
		let contextPath = '${pageContext.request.contextPath}';
	</script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="${pageContent.request.contextPath}/assets/js/questionRead.js"></script>
</body>
</html>