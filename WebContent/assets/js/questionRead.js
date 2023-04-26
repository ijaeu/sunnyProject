// 헤더부분 초록색 동그라미 띄우기
let $headerList = $('.header2-menu-list>a');
$headerList.removeClass('header-active');

let $headerGosu = $('#header-gosu');
$headerGosu.addClass('header-active');



$(".user-info").on("click", '.follow', function() {
	/*내가 누른 사람의 userNumber*/
	let userNumber = $(this).data('usernumber');
	let target = this;
	console.log(userNumber);
	$.ajax({
		url: "/follow/follow.fo",
		type: "get",
		success: function(result) {
			console.log(result);
			if (result == "fail") {
				window.location.href = "/user/login.us";
			} else {
				/*내가 누른 사람의 userNumber*/
				console.log(userNumber);
				console.log(target);
				$(target).toggleClass("following");
				// console.log(this);
				if ($(target).hasClass("following") === true) {
					$(target).text("팔로잉");
					// 비동기로 내 팔로잉테이블에 추가
					followInsertAjax(userNumber);
				} else {
					$(target).text("팔로우");
					// 비동기로 내 팔로잉테이블에서 삭제
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


// btn
let $listBtn = $('.list-btn');
let $modifyBtn = $('.modify-btn');
let $deleteBtn = $('.delete-btn');

let questionNumber = $listBtn.data("questionnumber");

console.log(questionNumber);

$listBtn.on('click', () => {
	window.location.href = '/question/questionListOk.qs?gosuNumber=' + gosuNumber;
});

$modifyBtn.on('click', () => {
	alert('게시글을 수정합니다. ');
	window.location.href = '/question/questionUpdate.qs?questionNumber=' + questionNumber + '&gosuNumber=' + gosuNumber;
});

$deleteBtn.on('click', () => {
	alert('게시글을 삭제합니다. ');
	window.location.href = '/question/questionDeleteOk.qs?questionNumber=' + questionNumber + '&gosuNumber=' + gosuNumber;
});


// 한번 실행
questionReplyAjax();


// 댓글 리스트 가져오기
function questionReplyAjax() {
	$.ajax({
		url: '/questionReply/questionReplyListOk.qr',
		type: 'get',
		data: { questionNumber: questionNumber },
		dataType: "json",
		success: showQuestionReply
	});
}

function showQuestionReply(replies) {
	$(".comment-list").empty();
	let text = '';
	replies.forEach(questionReply => {
		text += `
			<ul id="comment-list">
				<li>
					<div class="comment-info">
					<span class="user-profile-img-box"> 
					`
		if (questionReply.replyProfileSystemName) {
			text += `													
			<img src="${contextPath}/upload/profileUpload/${questionReply.replyProfileSystemName}" alt="">`
		} else {
			text += `
			<img src="${contextPath}/assets/img/myPage/logo.png" alt="">`
		}
		text += `</span>
						<span class="writer">${questionReply.userNickname}</span> <span class="date">${questionReply.replyDate}</span>
					</div>
					<div class="comment-content-wrap">
						<div class="comment-content">
							<p>${questionReply.replyContent}</p>
						</div>`
		if (userNumber == questionReply.userNumber) {
			text += `<div class="comment-btn-group">
							<button type="button" class="comment-modify-ready">수정</button>
							<button type="button" class="comment-delete" id="delete-btn" data-number="${questionReply.replyNumber}">삭제</button>
						</div>
						<div class="comment-btn-group none">
							<button type="button" class="comment-modify" data-number="${questionReply.replyNumber}">수정 완료</button>
						</div>`
		}

		text += `</div>
				</li>
			</ul>
		`;
	});
	$('.comment-list').html(text);
}

// 댓글 작성
$('.submit-btn').on('click', function() {
	$.ajax({
		url: '/questionReply/questionReplyWriteOk.qr',
		type: 'post',
		data: {
			questionNumber: questionNumber,
			gosuNumber: gosuNumber,
			userNumber: userNumber,
			replyContent: $('#content').val()
		},
		success: function() {
			questionReplyAjax();
			$('#content').val('');
		}
	});
});



// 댓글 삭제
$('.comment-list').on('click', '.comment-delete', function() {
	let replyNumber = $(this).data("number");

	$.ajax({
		url: "/questionReply/questionReplyDeleteOk.qr",
		type: "get",
		data: { replyNumber: replyNumber },
		success: function() {
			questionReplyAjax();
		alert('댓글을 삭제합니다. ');
		}
	});
});


// 댓글 수정
$('.comment-list').on('click', '.comment-modify-ready', function() {
	let $parent = $(this).closest('#comment-list');
	/*console.log($parent);*/

	let $children = $parent.find('.comment-btn-group');
	/*console.log($children);*/

	$children.eq(0).hide();
	$children.eq(1).show();

	let $content = $(this).parent().prev().children();
	console.log($content);

	$content.replaceWith(`<textarea class='modify-content'>${$content.text()}</textarea>`);
});

$('.comment-list').on('click', '.comment-modify', function() {
	let replyNumber = $(this).data('number');
	console.log(replyNumber);

	$.ajax({
		url: "/questionReply/questionUpdateOk.qr",
		type: "get",
		data: {
			replyNumber: replyNumber,
			replyContent: $('.modify-content').val()
		},
		success: function() {
			questionReplyAjax();
		alert('댓글을 수정합니다. ');
		}
	});
});

console.log('----------------------------');







