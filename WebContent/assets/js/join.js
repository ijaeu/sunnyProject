/**
 * 
 */

let requiredBox = document.querySelector(".required-box");
let modalBox = document.querySelector(".modal-box");
let xBox = document.querySelector(".x-box");
let requiredBox2 = document.querySelector(".required-box2");
let modalBox2 = document.querySelector(".modal-box2");
let xBox2 = document.querySelector(".x-box2");
let requiredBox3 = document.querySelector(".required-box3");
let modalBox3 = document.querySelector(".modal-box3");
let xBox3 = document.querySelector(".x-box3");

requiredBox.addEventListener("click", function() {
	modalBox.style.display = "flex";
	$(modalBox).center();
	openModal();
});

xBox.addEventListener("click", function() {
	modalBox.style.display = "none";
	closeModal();
});

requiredBox2.addEventListener("click", function() {
	modalBox2.style.display = "flex";
	$(modalBox2).center();
	openModal();
});

xBox2.addEventListener("click", function() {
	modalBox2.style.display = "none";
	closeModal();
});

requiredBox3.addEventListener("click", function() {
	modalBox3.style.display = "flex";
	$(modalBox3).center();
	openModal();
});

xBox3.addEventListener("click", function() {
	modalBox3.style.display = "none";
	closeModal();
});

/*center 함수 재정의*/
jQuery.fn.center = function() {
	this.css('top', Math.max(0, (($(window).height() - $(this).outerHeight()) / 2) + $(window).scrollTop()) + 'px');
	this.css('left', Math.max(0, (($(window).width() - $(this).outerWidth()) / 2) + $(window).scrollLeft()) + 'px');
	return this;
}

// 스크롤 비활성화
const openModal = (e) => {
	document.body.style.overflow = "hidden";
};

// 스크롤 활성화
const closeModal = (e) => {
	document.body.style.overflow = "unset";
};


/*비밀번호 선택 질문 미선택시 폼제출 막고, 나머지 폼도 미작성시 제출 막음*/

/* const selectBox = document.getElementById('select');
 const submitBtn = document.querySelector('.submit-button');
 const form = document.querySelector('form');
 
 console.log('aaaaa');
 console.log(submitBtn);
 
submitBtn.addEventListener('click', (event) => {
	 event.preventDefault(); // 이벤트의 기본 동작(즉, submit)을 막음
   if (selectBox.value === '-1') {
	 alert('비밀번호 찾기 질문을 선택해주세요.');
   } else {
   const form = document.querySelector('form');
   if (form.checkValidity()) {
	 form.submit();
   } else {
	 alert('필수항목이 완료되지 않았습니다.');
   }
 }
 });*/
// ========================================================  

/*아이디*/
let $idInput = $('#id');
let $checkMsg = $("#check-id-msg");

console.log($idInput.val());
var test = '';

$idInput.on('blur', function() {
	console.log('되나0');
	if ($(this).val() == '') {
		$checkMsg.text('아이디를 입력하세요');
		console.log($checkMsg.text());
	} else {
		let id = $idInput.val();
		console.log(id);
		$.ajax({
			url : '/user/checkIdOk.us',
			type: 'get',
			data: { userId: id },
			success: function(result) {
				if(result == 1) {
					$checkMsg.text('중복된 아이디 입니다.')
				  }else {
					checkIdValidity();
				}
		},
			error: function(a, b, c) {
				console.log(c);
			}
		});
	}
});

/*아이디 정규표현식*/
const regex1 = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z0-9]{5,10}$/;
function checkIdValidity() {
	if (regex1.test($idInput.val())) {
		$checkMsg.text("사용 가능한 아이디입니다.");
	} else {
		$checkMsg.html("사용 불가능한 아이디입니다. <br>영어, 숫자를 포함하여 5글자 이상 10글자 이하로 작성하세요!");
	}
}


/*비밀번호, 비밀번호 확인 일치 검사*/
let $pwInput = $("#password");
let $checkPwMsg = $("#check-pw-msg");
let $passwordErrorMsg = $('#password-error');

let password = document.getElementById("password");
let confirm_password = document.getElementById("confirm-password");
let password_error = document.getElementById("password-error");

function validatePassword() {
	if (password.value !== confirm_password.value) {
		confirm_password.setCustomValidity("두 비밀번호가 일치하지 않습니다.");
		password_error.textContent = "두 비밀번호가 일치하지 않습니다.";
	} else {
		confirm_password.setCustomValidity("");
		password_error.textContent = "";
	}
}

password.addEventListener("change", validatePassword);
confirm_password.addEventListener("keyup", validatePassword);
confirm_password.addEventListener("blur", function() {
	if (confirm_password.value === "") {
		confirm_password.setCustomValidity("두 비밀번호가 일치하지 않습니다.");
		password_error.textContent = "두 비밀번호가 일치하지 않습니다.";
	}
});

password.addEventListener("blur", validatePassword);
confirm_password.addEventListener("blur", validatePassword);



/*비밀번호 정규표현식*/
// 대소문자 상관 없이 영어가 포함, 숫자 포함, 특수문자 포함, 8글자 이상
const regex2 = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;

$pwInput.on('blur', function() {
	if (regex2.test($(this).val())) {
		$checkPwMsg.text("사용 가능한 비밀번호입니다.");
	} else {
		$checkPwMsg.html("사용 불가능한 비밀번호입니다. <br>영어, 숫자, 특수문자를 포함하여 8글자 이상 작성하세요!");
	}
});

// =========================================
/*이름 미입력 메세지*/
let $nameInput = $('#name');
let $nameMsg = $('#name-error');
let name = document.querySelector('input[name="userName"]');
let name_error = document.getElementById("name-error");

function validateName() {
	if (name.value === "") {
		name_error.textContent = "이름을 입력하세요";
	} else {
		name_error.textContent = "";
	}
}

name.addEventListener("blur", validateName);

//=============================================
/*닉네임 미입력 메세지*/

let $checkMsg2 = $("#nickname-error");
let $nickNameInput = $('#nickName');

$nickNameInput.on('blur', function() {
	if ($(this).val() == '') {
		$checkMsg2.text('닉네임을 입력하세요');
		console.log($checkMsg2.text());
	} else {
		let nickName = $nickNameInput.val();

		$.ajax({
			url : '/user/checkNickOk.us',
			type: 'get',
			data: { userNickname: nickName },
			success: function(result) {
				$checkMsg2.text(result);
			},
			error: function(a, b, c) {
				console.log(c);
			}

		});
	}
});

//==============================================
/*연락처 정규표현식*/
let $userPhoneInput =$('#phoneNumber');
let $userPhoneMsg = $('#phone-msg');
/*let phoneInput = document.querySelector('input[name="userPhone"]');
let phoneMsg = document.querySelector('#phone-msg');*/

const regPhone = /^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$/;

$userPhoneInput.on('blur', function(){
	if(regPhone.test($userPhoneInput.val())){
		$userPhoneMsg.text('');
	}else{
		$userPhoneMsg.html(" -를 포함한 올바른 형식의 '휴대폰번호'를 입력하세요.<br> ex.  010-1234-5678");
	}
});


/*phoneInput.addEventListener('input', function() {
	if (regPhone.test(phoneInput.value)) {
		phoneMsg.classList.remove('error');
		phoneMsg.textContent = '';
	} else {
		phoneMsg.classList.add('error');
		phoneMsg.innerHTML = " -를 포함한 올바른 형식의 '휴대폰번호'를 입력하세요.<br> ex.  010-1234-5678";
	}
});*/

//===================================================
/*이메일 정규표현식*/
let $userEmailInput = $('#email');
let $userEmailMsg = $('#check-email-msg');

$userEmailInput.on('blur', function(){
	var regEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	if(regEmail.test($userEmailInput.val())){
		$userEmailMsg.text('');
	}else{
		$userEmailMsg.text('올바른 이메일을 입력해주세요.');
	}
});

/*function validateEmail() {
	var emailInput = document.getElementsByName('userEmail')[0];
	var emailMsg = document.getElementById('check-email-msg');

	if (!regEmail.test(emailInput.value)) {
		emailMsg.style.display = 'block';
		emailMsg.textContent = '올바른 이메일을 입력해주세요.';
	} else {
		emailMsg.style.display = 'none';
	}
}*/




/*약관동의 전체 체크,전체 해제*/

$(document).ready(function() {
	// 전체 동의 체크박스 클릭 시 약관 3개 모두 체크
	$("input[value='전체 동의']").click(function() {
		if ($(this).prop("checked")) {
			$("input[type='checkbox']").prop("checked", true);
		} else {
			$("input[type='checkbox']").prop("checked", false);
		}
	});

	// 개별 약관 동의 체크박스 클릭 시 전체 동의 체크박스 체크 여부 결정
	$("input[type='checkbox']").click(function() {
		var requiredChecked = $("input[type='checkbox'][required]:checked").length;
		var optionalChecked = $("input[type='checkbox']:not([required]):checked").length;

		if (requiredChecked == 2 && optionalChecked == 1) {
			$("input[value='전체 동의']").prop("checked", true);
		} else if (requiredChecked < 2 || optionalChecked < 1) {
			$("input[value='전체 동의']").prop("checked", false);
		}

		if ($(this).attr("id") !== "allagree" && !$(this).prop("checked")) {
			$("input[value='전체 동의']").prop("checked", false);
		}
	});
});



/*조건에 맞지 않을 때 alert창 띄우고 회원가입 막기*/

/*let $idInput = $('#id');
let $checkMsg = $("#check-id-msg");
let $pwInput = $("#password");
let $checkPwMsg = $("#check-pw-msg");
let $nameInput = $('#name');
let $nameMsg = $('#name-error');
let $checkMsg2 = $("#nickname-error");
let $nickNameInput = $('#nickName');
let $userPhoneInput = ('#phoneNumber');
let $userPhoneMsg = ('#phone-msg');
let $userEmailInput = ('#email');
let $userEmailMsg = ('#check-email-msg');
let $confirmPwInput = $('#confirm-password');
let $passwordErrorMsg=$('#password-error');

*/
let $confirmPwInput = $('#confirm-password'); /*비밀번호확인 인풋칸*/
let $pwAnswerInput = $('#passwordAnswer1');   /*비밀번호찾기답변 인풋칸*/

$('.submit-button').on('click', function() {
	
	let cuIdMsg = $checkMsg.text(); //id
	let rgPwMsg = $checkPwMsg.text(); //비밀번호
	let pwErMsg = $passwordErrorMsg.text();//비밀번호확인
	let cuNameMsg = $nameMsg.text(); //이름
	let nickMsg = $checkMsg2.text(); //닉네임
	let cuPhoneMsg = $userPhoneMsg.text(); //핸드폰
	let cuEmailMsg = $userEmailMsg.text(); //이메일



	console.log(cuIdMsg.includes('중복')||cuIdMsg.includes('불가능')); // 아이디가 중복이거나 불가능이거나
	console.log(rgPwMsg.includes('불가능'));
	console.log(pwErMsg.includes('일치'));
	console.log(nickMsg.includes('중복')|| nickMsg.includes('입력')); //닉네임이 중복이거나 입력이거나
	console.log(cuNameMsg.includes('입력'));
	console.log(cuPhoneMsg.includes('올바른'));
	console.log(cuEmailMsg.includes('올바른'));

	if ($idInput.val() == '' || $pwInput.val() == '' || $confirmPwInput.val() == '' || $nameInput.val() == '' || $nickNameInput.val() == ''
		|| $userPhoneInput.val() == '' || $userEmailInput.val() == '' || $pwAnswerInput.val() == '') { alert('필수 입력 항목을 모두 입력하세요'); }
	else {
		if (!(cuIdMsg.includes('불') || cuIdMsg.includes('중복')) && !rgPwMsg.includes('불') && !pwErMsg.includes('일치') && !nickMsg.includes('중복')
			&& !cuPhoneMsg.includes('올바른') && !cuEmailMsg.includes('올바른')) {
			console.log('저장할 수 있음');
			$('form').submit();
		} else {
			alert('회원정보를 다시 확인해 주세요');
		}
	}
});


$('form').on('submit', function(e){
	e.preventDefault();	// 기본 이벤트를 막아주는 명령어
	
	console.log($('#agree').prop('checked'));
	
	if($('#agree').prop('checked')){
		this.submit();	//서브밋 이벤트를 발생시키는 요소(폼 요소에 사용해야 함)
	}else{
		alert('필수약관에 동의하세요');
	}
});



