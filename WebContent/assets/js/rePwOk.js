/**
 * 
 */

 /*비밀번호 일치 여부 검사*/
// inputPw 값이 변경될 때마다 실행
$('.inputPw').on('keyup', function () {
  var password = $('input[name=newPassword]').val(); // 비밀번호 값
  var passwordConfirm = $(this).val(); // 비밀번호 확인 값
  var errorSpan = $(this).siblings('.password-error'); // 오류 메시지 span

  if (password !== passwordConfirm) {
    errorSpan.text('두 비밀번호가 일치하지 않습니다.');
  } else {
    errorSpan.text('');
  }
});


/*비밀번호 정규표현식*/
 let $checkPwMsg = $("#check-pw-msg");
 let $pwInput = $("#newPassword");
 
 // 대소문자 상관 없이 영어가 포함, 숫자 포함, 특수문자 포함, 8글자 이상
const regex4 = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;

$pwInput.on('blur', function(){
   if(regex4.test(  $(this).val()   )){
      $checkPwMsg.text("사용 가능한 비밀번호입니다.");
   }else{
      $checkPwMsg.html("사용 불가능한 비밀번호입니다. <br>영어, 숫자, 특수문자를 포함하여 8글자 이상 작성하세요!");
   }
});