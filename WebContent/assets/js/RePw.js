/**
 * 
 */
 
 $(document).ready(function() {
  $('#confirm-button').on('click', function() {
    var userId = $('#userId').val();
    var findQuestionNumber = $('#select').val();
    var findPasswordAnswer = $('input[name=findPasswordAnswer]').val();
    var newPassword = $('input[name=newPassword]').val();

    $.ajax({
      url: '${pageContext.request.contextPath}/find/findPw.fp',
      type: 'POST',
      data: {
        userId: userId,
        findQuestionNumber: findQuestionNumber,
        findPasswordAnswer: findPasswordAnswer
      },
      success: function(result) {
        if (result === 'success') {
          alert('일치합니다. 비밀번호를 재설정해주세요.');
          $('#change-button').on('click', function() {
            $.ajax({
              url: '${pageContext.request.contextPath}/find/findPw.fp',
              type: 'POST',
              data: {
                userId: userId,
                newPassword: newPassword
              },
              success: function(result) {
                if (result === 'success') {
                  alert('비밀번호가 변경되었습니다.');
                  window.location.href = '${pageContext.request.contextPath}/user/login.us';
                } else {
                  alert('비밀번호 변경에 실패하였습니다.');
                }
              },
              error: function() {
                alert('비밀번호 변경에 실패하였습니다.');
              }
            });
          });
        } else {
          alert('일치하지 않습니다. 다시 입력해주세요.');
        }
      },
      error: function() {
        alert('비밀번호 찾기 질문 확인에 실패하였습니다.');
      }
    });
  });
});