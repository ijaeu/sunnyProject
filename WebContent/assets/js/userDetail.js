/**
 * 
 */

let $benBtn = $('.ben-btn');

let userNumber = $benBtn.data("usernumber");

console.log(userNumber);

$benBtn.on('click', () => {	
   window.location.href = '/admin/userKillOk.ad?userNumber=' + userNumber;
   alert('회원을 죽였습니다. ');
});





