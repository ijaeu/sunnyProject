
const search = document.querySelector(".search");
const btn = document.querySelector(".btn");
const input = document.querySelector(".input");

btn.addEventListener("click", () => {
	searchAction();
});

function searchAction() {
  const searchParam = $('#searchPram').val();
  if ($('#search').hasClass("active") === true) {
  	console.log(searchParam);
  	location.href = '/admin/gosuManage.ad?searchWord=' + searchParam; 
  }
  search.classList.toggle("active");
  input.focus();
}
	
$(document).ready(function() {
	const urlParams = new URL(location.href).searchParams;
	const searchWord = urlParams.get('searchWord');
	$('#searchPram').val(searchWord);
});