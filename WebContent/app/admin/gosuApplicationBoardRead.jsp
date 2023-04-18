<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>고수신청글</title>
<link rel="stylesheet"
	href="../../assets/css/gosuApplicationBoardRead.css" />
</head>
<jsp:include
	page="${pageContext.request.contextPath}/app/admin/adminHeader.jsp" />
<body>
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
						<h1>${applydata.getApplyTitle() }</h1>
					</div>
					<div class="gosu-applicant">
						<div class="applicant-info">
							<div class="applicant-user-name">
								<a href="">닉네임 : ${applydata.getUserNickname() }</a>
							</div>
						</div>
						<div class="application-date">
							<p>신청일 : ${applydata.getApplyDate() }</p>
						</div>
					</div>
					<!-- check box -->
					<div class="gosu-department-box">
						<div class="gosu-department">
							<div class="gosu-department-text">전문분야 :</div>
							<div class="gosu-department-text">${applydata.getGosuFieldNames() }</div>
						</div>
					</div>
					<!-- 임시 내용 -->
					<div class="view-content">${applydata.getApplyContent() }</div>
				</div>
				<div class="btn-group">
					<button type="button" class="ok-btn">수락</button>
					<button type="button" class="no-btn"
					data-userNumber="${applydata.getUserNumber()}"
					data-applyNumber="${applydata.getApplyNumber()}">거절</button>
					<button type="button" class="back-btn">목록</button>
				</div>
			</div>
		</div>
	</div>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
	<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
	<script src="../../assets/js/gosuApplicationBoardRead.js"></script>
</body>
</html>
