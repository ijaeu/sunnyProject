$(document).ready(function() {
    $("button").click(function() {
        var value = $(this).val();
        $.ajax({
            url : "${pageContext.request.contextPath}/algorithm/testTwo.ag",
            type : "GET",
            data : { "selectOne" : value },
            success : function(response) {
                $("#qna").hide();
                $("#question2").html(response).show();
            },
            error : function() {
                alert("오류가 발생하였습니다.");
            }
        });
    });
});


