// 메뉴바 누르면 색상변경
$(".header2-menu-list").on("click", function () {
  // console.log(this);
  let $tagA = $(this).children();
  // console.log($tagA);
  $(".header2-menu-list>a").removeClass("header-active");
  $tagA.toggleClass("header-active");
});
