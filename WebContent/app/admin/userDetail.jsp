<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>식집사상세정보</title>
<link rel="stylesheet" href="../../assets/css/userDetail.css" />
</head>
<body>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
	<div class="sidebar-read-all">
		<div class="sidevar">
			<div class="admin-info-all">
				<div class="admin-info">
					<div class="info-top">
						<h3>관리자</h3>
					</div>
				</div>
				<div class="admin-info2">
					<div class="admin-img-name-date">
						<div class="admin-imgbox">
							<div class="admin-img">
								<a href=""><img src="../../assets/img/admin/sogum.jpg"
									alt="" /></a>
							</div>
						</div>
						<div class="admin-name-date">
							<div class="admin-name">소금</div>
							<div class="admin-date">가입일 2023.03.21</div>
						</div>
					</div>
				</div>
			</div>
			<div class="manage-all">
				<div class="manage-manu">
					<div class="user-manage">
						<div class="user-manage-headline">
							<img src="../../assets/img/admin/user.png" alt="" />
							<h2>관리하기</h2>
						</div>
						<div class="hr">
							<hr />
						</div>
						<div class="user-manage-list">
							<div class="all-user-manage">
								<a href="userManage.ad">전체회원관리</a>
							</div>
							<div class="gosu-user-manage">
								<a href="gosuManage.ad">식고수회원관리</a>
							</div>
							<div class="gosu-application-user-manage">
								<a href="gosuApplicationBoardList.ad">식고수신청관리</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="board-read-all">
			<div class="read-container">
				<div class="view-wrap">
					<div class="view-title">
						<h1>식집사상세정보</h1>
					</div>
					<p>식집사의 상세정보를 보고 관리할 수 있습니다.</p>
				</div>
				<div class="user-detail">
					<table class="user-detail-explain">
						<thead>
							<tr>
								<th scope="cols">타이틀</th>
								<th scope="cols">내용</th>
							</tr>
						</thead>
						<c:choose>
							<c:when test="${not empty userDetail }">
								<tbody>
									<tr>
										<th scope="row">회원번호</th>
										<td>${userDetail.getUserNumber() }</td>
									</tr>
									<tr>
										<th scope="row">등급명</th>
										<td>${userDetail.getGradeName() }</td>
									</tr>
									<tr>
										<th scope="row">닉네임</th>
										<td>${userDetail.getUserNickname() }</td>
									</tr>
									<tr>
										<th scope="row">이름</th>
										<td>${userDetail.getUserName() }</td>
									</tr>
									<tr>
										<th scope="row">연락처</th>
										<td>${userDetail.getUserPhone() }</td>
									</tr>
									<tr>
										<th scope="row">이메일</th>
										<td>${userDetail.getUserEmail() }</td>
									</tr>
									<tr>
										<th scope="row">가입날짜</th>
										<td>${userDetail.getUserDate() }</td>
									</tr>
									<tr>
										<th scope="row">게시글수</th>
										<td>${userDetail.getStoryCount() }</td>
									</tr>
									<tr>
										<th scope="row">댓글수</th>
										<td>${userDetail.getReplyCount() }</td>
									</tr>
									<tr>
										<th scope="row">팔로잉수</th>
										<td>${userDetail.getFollowingCount() }</td>
									</tr>
									<tr>
										<th scope="row">팔로워수</th>
										<td>${userDetail.getFollowerCount() }</td>
									</tr>
								</tbody>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="2" align="center">회원 데이터가 안나와요. ㅜ</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</table>
				</div>
				<div class="user-btn-groups">
					<button type="button" class="ben-btn" data-userNumber="${userDetail.getUserNumber() }">제명</button>
				</div>
			</div>
		</div>
	</div>
	    <jsp:include
		page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="../../assets/js/userDetail.js"></script>
</body>
</html>
