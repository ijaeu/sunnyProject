$(document).ready(function() {
    $("body").on("click", "#question2 .btn", function() {
        var value = $(this).val();
        $.ajax({
            url : "${pageContext.request.contextPath}/algorithm/testThree.ag",
            type : "GET",
            data : { "selectTwo" : value },
            success : function(response) {
                $("#question2").hide();
                $("#question3").html(response).show();
            },
            error : function() {
                alert("오류가 발생하였습니다.");
            }
        });
    });
});