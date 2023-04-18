// 모달 열기
function showModal() {
  document.getElementById("myModal").style.display = "block";
}
 
// 모달 닫기
function closeModal() {
  document.getElementById("myModal").style.display = "none";
}
 
// 닫기 버튼 클릭 시 모달 닫기
document.querySelector(".close").addEventListener("click", closeModal);
 
// 모달 바깥 부분 클릭 시 모달 닫기
window.addEventListener("click", function(event) {
  if (event.target == document.getElementById("myModal")) {
    closeModal();
  }
});
