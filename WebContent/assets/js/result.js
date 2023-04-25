  var imagePaths = [
	  "../../assets/img/algorithm/plant1.jpg", 
	  "../../assets/img/algorithm/plant2.jpg", 
	  "../../assets/img/algorithm/plant3.jpg", 
	  "../../assets/img/algorithm/plant4.jpg", 
	  "../../assets/img/algorithm/plant5.jpg", 
	  "../../assets/img/algorithm/plant6.jpg", 
	  "../../assets/img/algorithm/plant7.jpg", 
	  "../../assets/img/algorithm/plant8.jpg", 
	  "../../assets/img/algorithm/plant9.jpg", 
	  "../../assets/img/algorithm/plant10.jpg", 
	  "../../assets/img/algorithm/plant11.jpg", 
	  "../../assets/img/algorithm/plant12.jpg", 
	  "../../assets/img/algorithm/plant13.jpg", 
	  "../../assets/img/algorithm/plant14.jpg", 
	  "../../assets/img/algorithm/plant15.jpg", 
	  "../../assets/img/algorithm/plant16.jpg", 
	  "../../assets/img/algorithm/plant17.jpg", 
	  "../../assets/img/algorithm/plant18.jpg", 
	  "../../assets/img/algorithm/plant19.jpg", 
	  "../../assets/img/algorithm/plant20.jpg", 
	  "../../assets/img/algorithm/plant21.jpg", 
	  "../../assets/img/algorithm/plant22.jpg", 
	  "../../assets/img/algorithm/plant23.jpg", 
	  "../../assets/img/algorithm/plant24.jpg", 
	  "../../assets/img/algorithm/plant25.jpg", 
	  "../../assets/img/algorithm/plant26.jpg", 
	  "../../assets/img/algorithm/plant27.jpg", 
	  "../../assets/img/algorithm/plant28.jpg", 
	  "../../assets/img/algorithm/plant29.jpg", 
	  "../../assets/img/algorithm/plant30.jpg", 
	  "../../assets/img/algorithm/plant31.jpg", 
	  "../../assets/img/algorithm/plant32.jpg", 
	  ];

  // 현재 이미지 인덱스
  var currentImageIndex = 0;

  // 이미지 로딩 함수
  function loadImages() {
    for (var i = 0; i < imagePaths.length; i++) {
      var img = new Image();
      img.src = imagePaths[i];
    }
  }

  // 이미지 변경 함수
  function changeImage() {
    var plantImage = document.getElementById("plantImage");
    plantImage.src = imagePaths[currentImageIndex];

    // 인덱스 조절
    currentImageIndex++;
    if (currentImageIndex >= imagePaths.length) {
      currentImageIndex = 0;
    }
  }

  // 일정 주기마다 이미지 변경
  setInterval(changeImage, 130); // 1.3초마다 이미지 변경

  // 페이지 로드 시 이미지 로딩
  window.onload = loadImages;
  

    // 5초 후에 result.ag로 이동하는 함수
    function moveToResult() {
        setTimeout(function () {
            location.href = "/algorithm/result.ag";
        }, 3000); // 5초 후에 result.ag로 이동
    }


    // 페이지가 로드될 때 실행되는 함수
    window.onload = function () {
        moveToResult(); // 3초 후에 result.jsp로 이동
    }

