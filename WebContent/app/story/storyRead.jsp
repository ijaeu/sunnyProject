<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>볕 들 일기</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/storyRead.css" />
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet" />
</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/header/header.jsp" />
	<div class="container">
		<article class="view-top">
			<div class="infomation">
				<div class="txt-area">
					<a href="${pageContext.request.contextPath}">
						<div class="profile-img">
							<img alt="" src="${story.getUserProfileImage()}">
						</div>
						<p class="profile">${story.getUserNickname()}</p>
					</a>
					<button type="button" id="follow-button"
						onclick="toggleFollow(this)" class="p1 follow dir">
						팔로우</button>
				</div>
			</div>

			<div class="like">
				<span class="hit">조회수</span> <span id="hits-count" class="hit-count">${story.getStoryViewcnt()}</span>
			</div>
		</article>


		<h1 class="ReadTitle">
			<c:out value="${story.getStoryTitle()}" />
		</h1>

		<div class="story-read">
			<div class="storyBox">
				<c:out value="${story.getStoryContent()}" escapeXml="false"></c:out>
				<c:forEach var="storyFile" items="${story.getStoryFiles()}">
					<div class="story-imgBox1">
						<img src="${pageContext.request.contextPath}/storyUpload/${storyFile.getFileSystemName1()}">
					</div>
				</c:forEach>
				<c:out value="${story.getStoryContent2()}" escapeXml="false"></c:out>
				<c:forEach var="storyFile" items="${story.getStoryFiles()}">
					<div class="story-imgBox2" style="${empty storyFile.getFileSystemName2() ? 'display:none;' : ''}">
						<img src="${pageContext.request.contextPath}/storyUpload/${storyFile.getFileSystemName2()}">
					</div>
				</c:forEach>
				<c:out value="${story.getStoryContent3()}" escapeXml="false"></c:out>
				<c:forEach var="storyFile" items="${story.getStoryFiles()}">
					<div class="story-imgBox3" style="${empty storyFile.getFileSystemName3() ? 'display:none;' : ''}">
						<img src="${pageContext.request.contextPath}/storyUpload/${storyFile.getFileSystemName3()}">
					</div>
				</c:forEach>
			</div>
		</div>

		<div class="btn-groups">
				<button type="button" class="list-btn" data-storyNumber="${story.getStoryNumber()}">목록</button>

			<c:if test="${sessionScope.userNumber == story.getUserNumber()}">
				<button type="button" class="modify-btn">수정</button>
				<button type="button" class="delete-btn">삭제</button>
			</c:if>
		</div>

		<div class="story-date">
			<p class="todate">
				<c:out value="${story.getStoryDate()}" />
			</p>
		</div>

		<!-- 댓글 수정중 -->

		<div class="comment-form">
			<div class="holder">
				<h3 class="subtit">
					댓글 <span class="fc1" id="comment-count"></span>
				</h3>
			</div>
			<form id="comment-form">
				<input type="hidden" name="storyNumber"
					value="${story.getStoryNumber()}" />
				<div class="form-group">
					<textarea name="content" id="content" placeholder="댓글 내용을 입력하세요."></textarea>
				</div>
				<button type="button" class="submit-btn">댓글 작성</button>
			</form>
		</div>

		<div class="comment-list">
			<ul id="comment-list">
				<li>
					<div class="comment-info">
						<span class="writer">홍길동</span> <span class="date">2222-22-22</span>
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
			</ul>
		</div>
	</div>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		let userNumber = "${sessionScope.userNumber}";
	</script>
	<script src="${pageContext.request.contextPath}/assets/js/storyRead.js"></script>
</body>
</html>
