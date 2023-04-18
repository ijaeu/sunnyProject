// 팔로워 팔로잉 리스트 top버튼
console.log("=================")
//=============================
//팔로잉페이지로 진입시 팔로잉버튼이 초록색 활성화
let href = window.location.href;

let url = new URL(href);
let urlParams = url.searchParams;
console.log(urlParams.get('tab'))

if (urlParams.get('tab') == 'following') {
	$(".top-btn").removeClass("active");
	$(".following-btn").addClass("active");
};
//=============================

// 팔로우하기 버튼 눌렀을 때 색 변환
$(".follow-list").on("click",'.user-follow', function() {
	/*내가 누른 사람의 userNumber*/
	let userNumber = $(this).data('usernumber');
	console.log(userNumber);

	$(this).toggleClass("following");
	// console.log(this);
	if ($(this).hasClass("following") === true) {
		$(this).text("팔로잉");
		// 비동기로 내 팔로잉테이블에 추가
		$.ajax({
			url: "/follow/followInsert.fo",
			type: "get",
			data: { userNumber: userNumber },
			success: function() {
				console.log("팔로우성공");
			},
			error: function(a, b, c) {
				console.log(c);
			}
		});
	} else {
		$(this).text("팔로우");
		// 비동기로 내 팔로잉테이블에서 삭제
		$.ajax({
			url: "/follow/followDelete.fo",
			type: "get",
			data: { userNumber: userNumber },
			success: function() {
				console.log("팔로우취소");
			},
			error: function(a, b, c) {
				console.log(c);
			}
		});
	}
});

