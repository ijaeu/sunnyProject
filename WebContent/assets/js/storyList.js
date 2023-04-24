let $headerList = $('.header2-menu-list>a');
$headerList.removeClass('header-active');

let $headerStory = $('#header-story');
$headerStory.addClass('header-active');


$(".listLi").on("click", '.follow', function () {
  let userNumber = $(this).data('usernumber');
  let target = this;
  
  $.ajax({
    url: "/follow/follow.fo",
    type: "get",
    success: function (result) {
      if (result == "fail") {
        window.location.href = "/user/login.us";
      } else {
        $(`.listLi .follow[data-usernumber='${userNumber}']`).toggleClass("following"); // 같은 유저넘버를 가진 모든 요소에 대해 클래스를 추가/제거합니다.
        
        if ($(target).hasClass("following") === true) {
          $(`.listLi .follow[data-usernumber='${userNumber}']`).text("팔로잉"); // 같은 유저넘버를 가진 모든 요소에 대해 텍스트를 변경합니다.
          followInsertAjax(userNumber);
        } else {
          $(`.listLi .follow[data-usernumber='${userNumber}']`).text("팔로우"); // 같은 유저넘버를 가진 모든 요소에 대해 텍스트를 변경합니다.
          followDeleteAjax(userNumber);
        }
      }
    }
  });
});



function followInsertAjax(userNumber) {
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
}

function followDeleteAjax(userNumber) {
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