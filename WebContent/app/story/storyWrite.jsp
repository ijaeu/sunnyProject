<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>볕 들 스토리 | 볕 들 무렵</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/storyWrite.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet" />
<!-- include libraries(jQuery, bootstrap) -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link
	href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
<%-- 	   <jsp:include
   page="${pageContext.request.contextPath}/app/header/header.jsp"/>  --%>
	<div class="container">
		<form
			action="${pageContext.request.contextPath}/story/storyWriteOk.st"
			id="write-form" method="post" enctype="multipart/form-data">
			<h1 class="sub-title">
				<span class="story-ico"></span> 스토리 글쓰기 <span class="story-txt">나만의
					볕 들 스토리</span>
			</h1>
			<div class="form-group">
				<input type="text" id="title" name="storyTitle" required
					placeholder="* 스토리 제목을 입력해주세요!" />
			</div>
			<div class="form-group">
				<div class="image-upload-wrap">
					<input type="file" id="file" name="storyFile"
						accept=".jpg, .jpeg, .png" multiple />
					<div class="image-upload-box">
						<div class="upload-text">
							<div class="upload-icon">
								<img src="https://www.shouse.garden/images/ico/photo_g.png"
									class="upload-icon" />
							</div>
							<div class="upload-count">커버사진 업로드</div>
						</div>
						<div class="upload-text">
							커버사진 1개만 업로드 가능(<span class="cnt">0</span>/1)
						</div>
						<div class="upload-text">파일 형식 : jpg, png, jpeg</div>
						<div class="upload-text">※ 이미지를 등록하면 즉시 반영됩니다.</div>
					</div>
					<div class="img-controller-box">
						<ul class="file-list"></ul>
					</div>
				</div>
			</div>

			<h1 class="mini-title">상세 내용 입력</h1>
			<div class="storyContent-box">
				<textarea id="summernote" name="storyContent"></textarea>
				<div class="form-group2">
					<div class="image-upload-wrap2">
						<input type="file" id="file2" name="file2"
							accept=".jpg, .jpeg, .png" multiple />
						<div class="image-upload-box2">
							<div class="upload-text">
								<div class="upload-icon">
									<img src="https://www.shouse.garden/images/ico/photo_g.png"
										class="upload-icon" />
								</div>
								<div class="upload-count">내용사진 업로드</div>
							</div>
							<div class="upload-text">
								내용사진 업로드 가능(<span class="cnt2">0</span>/1)
							</div>
							<div class="upload-text">파일 형식 : jpg, png</div>
							<div class="upload-text">※ 이미지를 등록하면 즉시 반영됩니다.</div>
						</div>
						<div class="img-controller-box2">
							<div class="file-list2"></div>
						</div>
					</div>
				</div>
				<div class="content-control">
					<button type="button" class="content-delete" id="delete-story-btn"></button>
				</div>
			</div>


			<div class="storyContent-box2">
				<textarea id="summernote2" name="storyContent2"></textarea>
				<div class="form-group2">
					<div class="image-upload-wrap2">
						<input type="file" id="file3" name="file3"
							accept=".jpg, .jpeg, .png" multiple />
						<div class="image-upload-box2">
							<div class="upload-text">
								<div class="upload-icon">
									<img src="https://www.shouse.garden/images/ico/photo_g.png"
										class="upload-icon" />
								</div>
								<div class="upload-count">내용사진 업로드</div>
							</div>
							<div class="upload-text">
								내용사진 업로드 가능(<span class="cnt3">0</span>/1)
							</div>
							<div class="upload-text">파일 형식 : jpg, png</div>
							<div class="upload-text">※ 이미지를 등록하면 즉시 반영됩니다.</div>
						</div>
						<div class="img-controller-box2">
							<div class="file-list3"></div>
						</div>
					</div>
				</div>
				<div class="content-control">
					<button type="button" class="content-delete" id="delete-story-btn"></button>
				</div>
			</div>



			<div class="storyContent-box3">
				<textarea id="summernote3" name="storyContent3"></textarea>
				<div class="form-group2">
					<div class="image-upload-wrap2">
						<input type="file" id="file4" name="file4"
							accept=".jpg, .jpeg, .png" multiple />
						<div class="image-upload-box2">
							<div class="upload-text">
								<div class="upload-icon">
									<img src="https://www.shouse.garden/images/ico/photo_g.png"
										class="upload-icon" />
								</div>
								<div class="upload-count">내용사진 업로드</div>
							</div>
							<div class="upload-text">
								내용사진 업로드 가능(<span class="cnt4">0</span>/1)
							</div>
							<div class="upload-text">파일 형식 : jpg, png</div>
							<div class="upload-text">※ 이미지를 등록하면 즉시 반영됩니다.</div>
						</div>
						<div class="img-controller-box2">
							<div class="file-list4"></div>
						</div>
					</div>
				</div>
				<div class="content-control">
					<button type="button" class="content-delete" id="delete-story-btn"></button>
				</div>
			</div>
			<div class="add-content">
				<button type="button" class="add-btn">내용을 추가해주세요!</button>
			</div>

			<!-- 폼 내용 -->
			<div class="btn-groups">
				<button type="submit" name="action" value="write" class="submit-btn">등록
					하기</button>
				<button type="button" class="cancel-btn">취소</button>
			</div>
		</form>
	</div>
	<script
		src="${pageContext.request.contextPath}/assets/js/storyWrite.js"></script>
	<jsp:include
		page="${pageContext.request.contextPath}/app/admin/footer.jsp" />
</body>
</html>
