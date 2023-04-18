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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/follow.css" />
</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/header/header.jsp" />
	<div class="container">
		<section class="top">
			<div class="button">
				<ul class="top-btn-ul">
					<!-- active클래스를 줬다 뺐다 -->
					<a href="${pageContext.request.contextPath}/follow/followerList.fo?userNumber=${userNumber}">
						<li class="top-btn  active">팔로워</li>
					</a>
					<a href="${pageContext.request.contextPath}/follow/followingList.fo?userNumber=${userNumber}&tab=following">
						<li class="top-btn following-btn">팔로잉</li>
					</a>
				</ul>
			</div>
		</section>
		<section class="bottom">
			<!-- 팔로잉/팔로우 리스트 띄우기 -->
			<div class="follow">
				<ul class="follow-list-ul">
					<c:choose>
						<c:when test="${not empty followList}">
							<c:forEach var="follow" items="${followList}">
								<li class="follow-list">
									<!-- 이 회원의 마이페이지로 이동 --> <a
									href="${pageContext.request.contextPath}/user/myPageOk.us?userNumber=${follow.getUserNumber()}">
										<div class="user-photo">
											<c:choose>
												<c:when test="${empty follow.getFileSystemName()}">
													<img
														src="${pageContext.request.contextPath}/assets/img/myPage/logo.png" />
												</c:when>
												<c:otherwise>
													<img
														src="${pageContext.request.contextPath}/uploadProfile/${follow.getFileSystemName()}"
														alt="" />
												</c:otherwise>
											</c:choose>
										</div>
										<div class="user-name">${follow.getUserNickname()}</div>
								</a> <!-- 버튼을 누르면 마이페이지에 저장됨 --> <!-- following 클래스를 줬다뺐다 -->
									<c:if test="${follow.getFollowingStatus() == 0 }">
									<button class="user-follow" data-userNumber="${follow.getUserNumber()}">팔로우</button>
									</c:if>
									<c:if test="${follow.getFollowingStatus() == 1}">
									<button class="user-follow following" data-userNumber="${follow.getUserNumber()}">팔로잉</button>
									</c:if>
								</li>
							</c:forEach>
						</c:when>
					</c:choose>
				</ul>
			</div>
		</section>
	</div>
	<script></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/follow.js"></script>
</body>
</html>
