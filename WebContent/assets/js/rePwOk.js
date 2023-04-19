/**
 * 
 */

/*비밀번호 일치 여부 검사*/
// inputPw 값이 변경될 때마다 실행
$('.inputPw').on('keyup', function () {
  var password = $('#newPassword').val(); // 비밀번호 값
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
   if(regex4.test($(this).val())){
      $checkPwMsg.text("사용 가능한 비밀번호입니다.");
   }else{
      $checkPwMsg.html("사용 불가능한 비밀번호입니다. <br>영어, 숫자, 특수문자를 포함하여 8글자 이상 작성하세요!");
   }
});



/*비밀번호 일치 확인 검사와 정규표현식을 통과하지 못했을 때 폼 제출 막기*/

$(document).ready(function() {
  $('form').submit(function(event) {
    event.preventDefault(); // 기본 동작인 폼 제출을 막음

    var passwordInput = $('#newPassword');
    var confirmPasswordInput = $('input[name=confirmPassword]');
    var errorSpan = confirmPasswordInput.siblings('.password-error');

    var password = passwordInput.val();
    var confirmPassword = confirmPasswordInput.val();

    var passwordPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()_+])[a-zA-Z\d!@#$%^&*()_+]{8,}$/;

    if (!passwordPattern.test(password)) {
      alert('비밀번호 입력값이 올바르지 않습니다.'); // 비밀번호 패턴 검사 실패 시 경고창 출력
      return;
    }

    if (password !== confirmPassword) {
      alert('비밀번호 입력값이 일치하지 않습니다.'); // 비밀번호 확인이 일치하지 않을 때 경고창 출력
      return;
    }

    // 모든 검증을 통과한 경우 폼을 제출
    this.submit();
  });
});
