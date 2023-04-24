<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>식고수에게 물어보기 | 볕 들 무렵</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/search.css" />
</head>

<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/header/header.jsp" />
	<section class="pcontainer">
		<div class="ex-search">
			<h3>우리집 반려식물을 도와줄 식고수를 찾아보세요!</h3>
			<!-- 검색 -->
			<div class="headsearch">
				<form
					action="${pageContext.request.contextPath}/gosu/searchByKeywordOk.gu"
					method="GET" class="expertsearch">
					<input type="text" placeholder="분야를 입력해 식고수 찾기" class="search-text"
						name="keyword" id="keyword" />
					<button class="s-btn" id="s-btn">검색</button>
				</form>
			</div>
		</div>
		<!-- 하단 -->
		<!-- 식고수들 -->
		<c:choose>
			<c:when test="${not empty gosus}">

				<c:forEach var="search" items="${gosus}">
					<div class="search">
						<!-- 고수 프로필사진 + 닉네임 + 팔로우 -->
						<div class="profile">
							<a
								href="${pageContext.request.contextPath}/user/myPageOk.us?userNumber=${search.getUserNumber()}">
								<div class="profile-photo">
									<c:choose>
										<c:when test="${empty search.getFileSystemName()}">
											<img
												src="${pageContext.request.contextPath}/assets/img/myPage/logo.png" />
										</c:when>
										<c:otherwise>
											<img
												src="${pageContext.request.contextPath}/upload/profileUpload/${search.getFileSystemName()}"
												alt="" />
										</c:otherwise>
									</c:choose>
								</div>
								<div class="expertname">
									식고수
									<c:out value="${search.getUserNickname()}" />
								</div>
							</a>

							<div class="follow-btn">
								<!-- 내가 팔로우하고 있으면 팔로잉으로 띄움 -->
								<c:if
									test="${sessionScope.userNumber !=  search.getUserNumber()}">
									<c:if test="${search.getFollowingStatus() == 0 }">
										<button class="user-follow"
											data-userNumber="${search.getUserNumber()}">팔로우</button>
									</c:if>
									<c:if test="${search.getFollowingStatus() == 1}">
										<button class="user-follow following"
											data-userNumber="${search.getUserNumber()}">팔로잉</button>
									</c:if>
								</c:if>
							</div>
						</div>
						<!-- 소개랑 분야 -->
						<div class="container">
							<div class="info">

								<p class="gosu-introduction">
									"<span><c:out value="${search.getUserComment()}" /></span>"

								</p>
								<p class="info-gosu gosu-majorname">
									식고수 <span class="gosu-name"><c:out
											value="${search.getUserNickname()}" /></span>님에게
								</p>
								<p class="info-gosu">
									<span class="gosu-field"><c:out
											value="${search.getGosuFields()}" /></span> 키우는 법을 질문하세요!
								</p>

							</div>
							<div class="write-btn-wrap">
								<!-- 더보기 페이지 -->
								<a
									href="${pageContext.request.contextPath}/question/questionListOk.qs?gosuNumber=${search.getGosuNumber()}"
									class="plus-btn" onclick="questionList()">더보기</a>
							</div>
						</div>

					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="empty">
				<p>찾으시는 식고수가 아직 없습니다.</p>
				<a href="${pageContext.request.contextPath}/gosu/searchOk.gu">돌아가기</a>
				</div>
			</c:otherwise>
		</c:choose>
		
		
		<!-- 페이징처리부분 -->
		<div class="pagination">
		<ul>
			<c:if test="${prev}">
				<li><a
					href="${pageContext.request.contextPath}/gosu/searchOk.gu?page=${startPage -1}"
					class="prev">&lt;</a></li>
			</c:if>

			<c:forEach var="i" begin="${startPage}" end="${endPage}">
				<c:choose>
					<c:when test="${!(i==page)}">
						<li><a
							href="${pageContext.request.contextPath}/gosu/searchOk.gu?page=${i}">
								<c:out value="${i}" />
						</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#" class="active"> <c:out value="${i}" />
						</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${next}">
				<li><a
					href="${pageContext.request.contextPath}/gosu/searchOk.gu?page=${endPage +1}"
					class="next">&gt;</a></li>
			</c:if>
		</ul>
	</div>
	</section>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/search.js"></script>
</body>

</html>