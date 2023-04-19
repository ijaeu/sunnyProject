let $headerList = $('.header2-menu-list>a');
$headerList.removeClass('header-active');

let $headerStory = $('#header-story');
$headerStory.addClass('header-active');


$(".listLi").on("click",'.follow', function() {
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