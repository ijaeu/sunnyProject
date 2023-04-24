let $headerList = $('.header2-menu-list>a');
$headerList.removeClass('header-active');

let $headerStory = $('#header-story');
$headerStory.addClass('header-active');


/*function toggleFollow(button) {
	if (button.innerHTML === "팔로우") {
		button.innerHTML = "팔로잉";
		button.classList.toggle("following", true);
		button.classList.toggle("follow", false);
	} else {
		button.innerHTML = "팔로우";
		button.classList.toggle("following", false);
		button.classList.toggle("follow", true);
	}
}*/

$(".view-top").on("click", '.follow', function() {
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


let $listBtn = $('.list-btn');
let $modifyBtn = $('.modify-btn');
let $deleteBtn = $('.delete-btn');

let storyNumber = $listBtn.data("storynumber");

console.log(storyNumber);

$listBtn.on('click', () => {
	window.location.href = '/story/storyListOk.st';
});

$modifyBtn.on('click', () => {
	window.location.href = '/story/storyUpdate.st?storyNumber=' + storyNumber;
});

$deleteBtn.on('click', () => {
	window.location.href = '/story/storyDeleteOk.st?storyNumber=' + storyNumber;
});

storyReplyAjax();

function storyReplyAjax() {
	$.ajax({
		url: '/storyReply/storyReplyListOk.sr',
		type: 'get',
		data: { storyNumber: storyNumber },
		dataType: "json",
		success: showStoryReply
	});
}

function showStoryReply(replies) {
	let text = '';

	replies.forEach(storyReply => {
		text += `
			<ul id="comment-list">
				<li>
					<div class="comment-info">
						<span class="writer">${storyReply.userNickname}</span> <span class="date">${storyReply.replyDate}</span>
					</div>
					<div class="comment-content-wrap">
						<div class="comment-content">
							<p>${storyReply.replyContent}</p>
						</div>`
		if (userNumber == storyReply.userNumber) {
			text += `<div class="comment-btn-group">
							<button type="button" class="comment-modify-ready">수정</button>
							<button type="button" class="comment-delete" data-number="${storyReply.replyNumber}">삭제</button>
						</div>
						<div class="comment-btn-group none">
							<button type="button" class="comment-modify" data-number="${storyReply.replyNumber}">수정 완료</button>
						</div>`
		}

		text += `</div>
				</li>
			</ul>
		`;
	});

	$('.comment-list').html(text);
}

//댓글작성
$('.submit-btn').on('click', function() {
	$.ajax({
		url: '/storyReply/storyReplyWriteOk.sr',
		type: 'post',
		data: {
			storyNumber: storyNumber,
			userNumber: userNumber,
			replyContent: $('#content').val()
		},
		success: function() {
			storyReplyAjax();
		}
	});
});


//댓글삭제
$('.comment-list').on('click', '.comment-delete', function() {
	console.log("delete!! 댓글 삭제 레츠기릿");
	let replyNumber = $(this).data("number");

	$.ajax({
		url: "/storyReply/storyReplyDeleteOk.sr",
		type: "get",
		data: { replyNumber: replyNumber },
		success: function() {
			storyReplyAjax();
		}
	});
});

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

	$.ajax({
		url: "/storyReply/storyReplyUpdateOk.sr",
		type: "get",
		data: {
			replyNumber: replyNumber,
			replyContent: $('.modify-content').val()
		},
		success: function() {
			storyReplyAjax();
		}
	});
});

console.log('----------------------------');





