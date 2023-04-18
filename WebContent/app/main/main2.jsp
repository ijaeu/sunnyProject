<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main2.css" />
</head>
</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/header/header.jsp" />
	<main class="container">
		<!-- 배너 -->
		<section class="main1">
			<div class="main1-banner-wrap">
				<ul class="main1-slide-ul">
					<li class="banner"><a
						href="${pageContext.request.contextPath}/story/storyListOk.st">
							<p class="banner1">우리집 반려식물 이야기</p> <img
							src="${pageContext.request.contextPath}/assets/img/main/mainBanner1.jpg"
							alt="">
					</a></li>
					<li class="banner"><a
						href="${pageContext.request.contextPath}/gosu/searchOk.gu">
							<p class="banner2">식고수에게 물어보세요</p> <img
							src="${pageContext.request.contextPath}/assets/img/main/mainBanner2.jpg"
							alt="">
					</a></li>
					<li class="banner"><a
						href="${pageContext.request.contextPath}/app/algorithm/index.jsp">
							<p class="banner3">나에게 꼭 맞는 반려식물찾기</p> <img
							src="${pageContext.request.contextPath}/assets/img/main/mainBanner3.jpg"
							alt="">
					</a></li>

				</ul>
				<p class="slide-controller">
					<!-- &lang: 왼쪽 방향 화살표 &rang: 오른쪽 방향 화살표 -->
					<span class="prev">&lang;</span> <span class="next">&rang;</span>
				</p>
			</div>
		</section>

		<!-- 스토리구역 -->
		<section class="main2">

			<div class="main2-top">
				<h3>스토리</h3>
				<!-- 더보기를 누르면 스토리리스트 페이지로 이동 -->
				<a href="${pageContext.request.contextPath}/story/storyListOk.st">더보기
					></a>
			</div>

			<!-- 스토리 리스트 -->
			<div class="main2-bottom">
				<ul class="main2-story-list-ul">
					<c:choose>
						<c:when test="${not empty main.getStoryList()}">
							<c:forEach var="mainStory" items="${main.getStoryList()}">
								<li class="main2-story-list">
									<div class="main2-story-list-user">
										<!-- 프로필을 누르면 이사람의 마이페이지로 이동 -->
										<a href="${pageContext.request.contextPath}/user/myPageOk.us?userNumber=${mainStory.getUserNumber()}">
											<div class="story-user-photo">
												<img src="${pageContext.request.contextPath}/uploadProfile/${mainStory.getUserProfileImage()}" alt="">
											</div>
											<p>${mainStory.getUserNickname()}</p>
										</a>
									</div>
									<div class="main2-story-list-content">
										<!-- 게시물을 누르면 해당 스토리읽기 페이지로 이동 -->
										<a href="${pageContext.request.contextPath}/story/storyListOk.st?storyNumber=${mainStory.getStoryNumber()}">
										<!-- 스토리커버사진, 제목 -->
											<div class="story-cover-photo">
												<img src="${pageContext.request.contextPath}/storyUpload/${mainStory.getFileSystemName()}" alt="">
											</div>
											<p>${mainStory.getStoryTitle()}</p>
										</a>
									</div>
								</li>
							</c:forEach>
						</c:when>

					</c:choose>


				</ul>
			</div>
		</section>

		<!-- 식고수찾기구역 -->
		<section class="main3">
			<article class="main3-wrap">
				<!-- 식고수 리스트를 띄운다 1명 가장 질문 많은 순 -->
				<div class="main3-left">
					<ul class="main3-gosu-list-ul">
						<li class="main3-gosu-li">
							<!-- 선택한 식고수의 질문페이지로 이동--> <a href="${pageContext.request.contextPath}/question/questionListOk.qs?gosuNumber=${main.getGosu().getGosuNumber()}">
								<div class="main3-gosu-name">
									<!-- 식고수이름 span에 꽂아준다 -->
									<h3>
										식고수 <span><c:out value="${main.getGosu().getUserNickname()}" /></span>님에게
									</h3>
									<h3>물어보세요</h3>
								</div> <!-- 식고수프로필사진 꽂아준다 -->
								<div class="main3-gosu-photo">
									<img src="${pageContext.request.contextPath}/uploadProfile/${main.getGosu().getFileSystemName()}" alt="">
								</div> <!-- 식물분야 span에 꽂아준다 -->
								<p>
									<span><c:out value="${main.getGosu().getGosuFields()}" /></span> 키우는 꿀팁!
								</p>
						</a>
						</li>
					</ul>
				</div>
				<div class="main3-right">
					<!-- 식고수리스트페이지로이동 -->
					<a href="${pageContext.request.contextPath}/gosu/searchOk.gu"
						class="to-gosu-list-page">
						<div class="main3-right-inner">
							<p>
								식물마다 노하우가 달라요, <br> 우리집 반려식물에 꼭 맞는 노하우를 알려주실<br>더 많은
								식고수님들을 찾아보세요!
							</p>
						</div>
					</a>
				</div>
				</div>
			</article>
		</section>

		<!-- 식물찾기구역 -->
		<section class="main4">
			<!-- 식물찾기 알고리즘 페이지로 이동 -->
			<div class="main4-box"
				style="background-image:url('${pageContext.request.contextPath}/assets/img/main/mainBanner3.jpg')">
				<a href="${pageContext.request.contextPath}/app/algorithm/index.jsp">
					<p>나에게 꼭 맞는 반려식물을 찾아보세요</p>
				</a>
			</div>
			</a>
		</section>

	</main>



	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main2.js"></script>
</body>
</html>