//헤더부분에 초록동그라미띄우기
let $headerList = $('.header2-menu-list>a');
$headerList.removeClass('header-active');

let $headerMypage = $('#header-mypage');
$headerMypage.addClass('header-active');


// 취소버튼을 눌렀을 때 다시 마이페이지로 돌아감

$('.modify-cancel-btn').on('click',()=>{
console.log("되냐");
	window.location.href = '/user/myPageOk.us';
});

console.log(userNumber);
// 현재 비밀번호를 입력했을 때 비동기로 맞는지 확인
// 맞으면 초록색으로 '현재 비밀번호가 확인되었습니다.' '올바른 비밀번호를 입력해주세요.'
// 비밀번호를 맞게 입력하지 못하면 회원정보를 변경할 수 없게 한다. 

// 비밀번호 인풋칸
let $currentPwInput = $('#current-password');
let $userPwInput = $('#user-password');
let $checkPwInput = $('#check-user-password');

// 메세지 띄울 곳들
let $cuPwMsg = $('#check-cupw-msg');
let $userPwMsg = $('#check-pw-msg');
let $chPwMsg = $('#check-chpw-msg');

$currentPwInput.on('blur', function(){
	if($(this).val()==''){
		$cuPwMsg.text('비밀번호를 입력하세요');
	}else{
		let pw = $currentPwInput.val();
		$.ajax({
			url : '/user/checkPwOk.us',
			type : 'get',
			data : {
				userNumber : userNumber,
				userPassword : pw			
			},
			success : function(result){
				$cuPwMsg.text(result);
			},
			error : function(a,b,c){
				console.log(c);
			}
		});
	}
});

// 변경 비밀번호를 입력하고 그 다음칸에 같은걸 입력했는지 확인
$checkPwInput.on('blur', function(){
	if($userPwInput.val()==$checkPwInput.val()){
		$chPwMsg.text("비밀번호가 일치합니다.");
	}else{
		$chPwMsg.text("비밀번호가 일치하지 않습니다.");
	}
});

// 닉네임인풋칸
$nicknameInput = $('#user-nickname');
// 닉네임 메세지칸
$nicknameMsg = $('#check-nickname-msg');

// 중복된 닉네임인지 확인
$nicknameInput.on('blur', function(){
	if($nicknameInput.val()==''){
		$nicknameMsg.text('닉네임을 입력하세요');
	}else{
		let nick = $nicknameInput.val();
		$.ajax({
			url : '/user/checkNickOk.us',
			type : 'get',
			data : {
				userNickname : nick 	
			},
			success : function(result){
				$nicknameMsg.text(result);
			},
			error : function(a,b,c){
				console.log(c);
			}
		});
	}
})

$('.modify-submit-btn').on('click', function(){
	 
	let cuPwMsg = $cuPwMsg.text();
	let chPwMsg = $chPwMsg.text();
	let nickMsg = $nicknameMsg.text();
	
	console.log(cuPwMsg.includes('않')); 
	
	if($currentPwInput.val()==''){
		alert('현재 비밀번호를 입력해주세요');
	}else if($userPwInput.val()==''){
		alert('변경할 비밀번호를 입력해주세요');
	}else if($checkPwInput.val()==''){
		alert('변경할 비밀번호 확인을 입력해주세요')
	}else{
		if(!cuPwMsg.includes('않') && !chPwMsg.includes('않') && !nickMsg.includes('중복')){
			console.log('저장할 수 있음');
			$('form').submit();
		}else{
			alert('회원정보를 다시 확인해 주세요');
		}
	}
});

