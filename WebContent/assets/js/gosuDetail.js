/**
 * 
 */

let $benBtn = $('.ben-btn');
let $downBtn = $('.down-btn');

let userNumber = $benBtn.data("usernumber");

console.log(userNumber);

$benBtn.on('click', () => {	
   window.location.href = '/admin/gosuKillOk.ad?userNumber=' + userNumber;
   alert('고수 회원을 죽였습니다.');
});

$downBtn.on('click', () => {	
   window.location.href = '/admin/gosuDownOk.ad?userNumber=' + userNumber;
   alert('고수 회원을 반쯤 죽였습니다.');
});




