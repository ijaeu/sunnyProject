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

requiredBox.addEventListener("click", function () {
  modalBox.style.display = "flex";
  $(modalBox).center();
  openModal();
});

xBox.addEventListener("click", function () {
  modalBox.style.display = "none";
  closeModal();
});

requiredBox2.addEventListener("click", function () {
  modalBox2.style.display = "flex";
  $(modalBox2).center();
  openModal();
});

xBox2.addEventListener("click", function () {
  modalBox2.style.display = "none";
  closeModal();
});

requiredBox3.addEventListener("click", function () {
  modalBox3.style.display = "flex";
  $(modalBox3).center();
  openModal();
});

xBox3.addEventListener("click", function () {
  modalBox3.style.display = "none";
  closeModal();
});

/*center 함수 재정의*/
jQuery.fn.center = function () {
	this.css('top', Math.max(0,(($(window).height()-$(this).outerHeight())/2) + $(window).scrollTop())+'px');
	this.css('left', Math.max(0,(($(window).width()-$(this).outerWidth())/2) + $(window).scrollLeft())+'px');
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
  
  
  
  /*비밀번호, 비밀번호 확인 일치 검사*/
  
 	const password = document.getElementById("password");
	const confirm_password = document.getElementById("confirm-password");
	const password_error = document.getElementById("password-error");

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
confirm_password.addEventListener("blur", function () {
  if (confirm_password.value === "") {
    confirm_password.setCustomValidity("두 비밀번호가 일치하지 않습니다.");
    password_error.textContent = "두 비밀번호가 일치하지 않습니다.";
  }
});

	password.addEventListener("blur", validatePassword);
	confirm_password.addEventListener("blur", validatePassword);

/*이름 미입력 메세지*/
	const name = document.querySelector('input[name="userName"]');
	const name_error = document.getElementById("name-error");

	function validateName() {
  	if (name.value === "") {
  	  name_error.textContent = "이름을 입력하세요";
  	} else {
   	 name_error.textContent = "";
 	 }
	}

	name.addEventListener("blur", validateName);


/*닉네임 미입력시 메세지*/
	const nickname = document.querySelector('input[name="userNickname"]');
	const nickname_error = document.getElementById("nickname-error");

	function validateNickname() {
 	 if (nickname.validity.valueMissing) {
    nickname_error.textContent = "닉네임을 입력하세요";
  } else {
    nickname_error.textContent = "";
  }
}

	nickname.addEventListener("blur", validateNickname);



/**/



let $checkMsg = $("#check-id-msg");
let $checkPwMsg = $("#check-pw-msg");

let $idInput = $('#id');
let $pwInput = $("#password");

var test = '';

$idInput.on('blur', function(){
   if($(this).val() == '') {
      $checkMsg.text('아이디를 입력하세요!');
   } else {
      let id = $idInput.val();
   
   $.ajax({
      url : '/member/checkIdOk.me',
      type : 'get',
      data : {memberId : id},
      success : function(result) {
         $checkMsg.text(result);
         test = result;
      },
      error : function(a,b,c){
         console.log(c);
      }
      
   });
   }
});

//중복 검사를 위한 ajax
	$idInput.on('change', function() {
   let id = $idInput.val();
   
   $.ajax({
      url : '/user/checkIdOk.us',
      type : 'get',
      data : {userId : id},
      success : function(result) {
         $checkMsg.text(result);
         test = result;
         if (result === "사용 가능한 아이디입니다.")  {
         checkIdValidity();
         }
      },
      error : function(a,b,c){
         console.log(c);
      }
      
   });
   
});

function checkIdValidity() {
   const regex1 = /^(?=.*[a-zA-Z])(?=.*\d)[a-zA-Z0-9]{5,10}$/;
   if(regex1.test( $idInput.val() )) {
      $checkMsg.text("사용 가능한 아이디입니다.");
   } else {
      $checkMsg.html("사용 불가능한 아이디입니다. <br>영어, 숫자를 포함하여 5글자 이상 10글자 이하로 작성하세요!");
   }
}


// 대소문자 상관 없이 영어가 포함, 숫자 포함, 특수문자 포함, 8글자 이상
const regex2 = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;

$pwInput.on('blur', function(){
   if(regex2.test(  $(this).val()   )){
      $checkPwMsg.text("사용 가능한 비밀번호입니다.");
   }else{
      $checkPwMsg.html("사용 불가능한 비밀번호입니다. <br>영어, 숫자, 특수문자를 포함하여 8글자 이상 작성하세요!");
   }
});


/*약관동의 전체 체크,전체 해제*/

$(document).ready(function() {
  // 전체 동의 체크박스 클릭 시 약관 3개 모두 체크
  $("input[value='전체 동의']").click(function() {
    if($(this).prop("checked")) {
      $("input[type='checkbox']").prop("checked", true);
    } else {
      $("input[type='checkbox']").prop("checked", false);
    }
  });
  
  // 개별 약관 동의 체크박스 클릭 시 전체 동의 체크박스 체크 여부 결정
  $("input[type='checkbox']").click(function() {
    var requiredChecked = $("input[type='checkbox'][required]:checked").length;
    var optionalChecked = $("input[type='checkbox']:not([required]):checked").length;
    
    if(requiredChecked == 2 && optionalChecked == 1) {
      $("input[value='전체 동의']").prop("checked", true);
    } else if(requiredChecked < 2 || optionalChecked < 1) {
      $("input[value='전체 동의']").prop("checked", false);
    } 
    
    if($(this).attr("id") !== "allagree" && !$(this).prop("checked")) {
      $("input[value='전체 동의']").prop("checked", false);
    }
  });
});



/*연락처 정규표현식*/

const phoneInput = document.querySelector('input[name="userPhone"]');
const phoneMsg = document.querySelector('#phone-msg');

phoneInput.addEventListener('input', function() {
  const regPhone = /^01([0|1|6|7|8|9])-([0-9]{3,4})-([0-9]{4})$/;
  if (regPhone.test(phoneInput.value)) {
    phoneMsg.classList.remove('error');
    phoneMsg.textContent = '';
  } else {
    phoneMsg.classList.add('error');
    phoneMsg.innerHTML = " -를 포함한 올바른 형식의 '휴대폰번호'를 입력해주세요.<br> ex.  010-1234-5678";
  }
});


/*이메일 정규표현식*/

function validateEmail() {
  var emailInput = document.getElementsByName('userEmail')[0];
  var emailMsg = document.getElementById('check-email-msg');
  var regEmail = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
  
  if (!regEmail.test(emailInput.value)) {
    emailMsg.style.display = 'block';
    emailMsg.textContent = '올바른 이메일을 입력해주세요.';
  } else {
    emailMsg.style.display = 'none';
  }
}





