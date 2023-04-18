/**
 * 
 */

let queryString = location.search;

let urlParams = new URLSearchParams(queryString);

let login = urlParams.get('login');

if(login == 'fail'){
	alert('일치하는 회원 정보가 없습니다.');
}

if(login == 'noInfo'){
	alert('로그인 정보가 없습니다.');
	}
	
if(login == 'logout'){
	alert('로그아웃되셨습니다.');
	}	