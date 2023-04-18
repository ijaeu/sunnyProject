/**
 * 
 */


let $okBtn = $('.ok-btn');
let $noBtn = $('.no-btn');
let $backBtn = $('.back-btn');

let userNumber = $noBtn.data("usernumber");
let applyNumber = $noBtn.data("applynumber");

console.log(userNumber);

$okBtn.on('click', () => {	
   window.location.href = '/admin/gosuApplyOk.ad?userNumber=' + userNumber;
   alert('고수 회원을 만들엇습니다.');
});

$noBtn.on('click', () => {	
   window.location.href = '/admin/gosuApplyNo.ad?userNumber=' + userNumber + '&applyNumber=' + applyNumber;
   alert('신청을 거절하였습니다.');
});

$backBtn.on('click', () => {	
   window.location.href = '/admin/gosuApplicationBoardList.ad';
});

















