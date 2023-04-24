// 헤더부분 초록색 동그라미 띄우기
let $headerList = $('.header2-menu-list>a');
$headerList.removeClass('header-active');

let $headerGosu = $('#header-gosu');
$headerGosu.addClass('header-active');

let $noAnswerList = $('.no-answer');
let $answerList = $('.ok-answer');

$noAnswerList.click(function() {
	$.ajax({
		url: "/question/questionListChange.qs",
      	type: 'get',
      	data: { 
			questionStatus: 0 ,
			gosuNumber : gosuNumber
		}, 
      	dataType: "json",
      	success: function(data) {
        // questionlist 업데이트
        updateQuestionList(data);
		console.log('답변대기ajax')
     	}
    });
 });

$answerList.click(function() {
	$.ajax({
		url: "/question/questionListChange.qs",
      	type: 'get',
      	data: { 
			questionStatus: 1 , 
			gosuNumber : gosuNumber
		},
      	dataType: "json",
      	success: function(data) {
        // questionlist 업데이트
        updateQuestionList(data);
		console.log('답변완료ajax')
     	}
    });
 });

 // questionlist 업데이트 함수
  function updateQuestionList(data) {
    // 기존의 questionlist 엘리먼트를 삭제
    $(".question-list").empty();
		let text = '';
		data.forEach(question => {
			text += `<div class="question">
									<div class="question-mark-box">
										<img src="../../assets/img/admin/qeustionIcon.png" alt="">
									</div>
									<div class="question-title">
										<a href="/question/questionReadOk.qs?questionNumber=${question.questionNumber}">${question.questionTitle }</a>
									</div>
									<div class="user-profile-box">
									<div class="user-profile-img-box">
										<a href="/user/myPageOk.us?userNumber=question.userNumber"><img src="${contextPath}/upload/profileUpload/${question.fileSystemName}" alt=""></a>
									</div>	
									<div class="user-nickname-box"><a href="/user/myPageOk.us?userNumber=question.userNumber">${question.userNickname }</a>
									</div>
									</div>
									<div class="question-date"><p>작성시간<hr>${question.questionDate }</p></div>
								</div>			
			`
		});
		$(".question-list").html(text);
 };

const answerBtns = document.querySelectorAll('.anwer-btn li');

// 첫 번째 li 요소에 배경색 적용
answerBtns[0].classList.add('active');

// 각 li 요소에 클릭 이벤트 등록
answerBtns.forEach((btn) => {
  btn.addEventListener('click', () => {
    // 클릭한 li 요소에만 배경색 적용
    answerBtns.forEach((btn) => {
      btn.classList.remove('active');
    });
    btn.classList.add('active');
  });
});































