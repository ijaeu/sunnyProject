/**
 * 
 */


 
 let questionBtn = document.querySelector(".question-btn");

//  팔로우버튼 
    var count = 1;
    function colorChange(e) {
        var property = document.getElementById("ff-btn");
        if (count == 0) {
            property.style.backgroundColor = "#009a3e"
            count = 1;       
        }
        else {
            property.style.backgroundColor = "black"
            count = 0;
        }
    }

//질문목록
function questionList(e){
    window.location.href="/question/questionList.qs";
}

 // 질문하기 버튼 (누르면 질문쓰는 곳으로 이동)
function goQuestion(e) {
    window.location.href="question/questionWrite.qs";
}

function goQuestion2(e){
	window.location.href="question/questionList2.qs"
}






