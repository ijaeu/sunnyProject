  var imagePaths = [
	  "../../assets/img/algorithm/00000.jpg", 
	  "../../assets/img/algorithm/00001.jpg", 
	  "../../assets/img/algorithm/00010.jpg", 
	  "../../assets/img/algorithm/00011.jpg", 
	  "../../assets/img/algorithm/00101.jpg", 
	  "../../assets/img/algorithm/00110.jpg", 
	  "../../assets/img/algorithm/00111.jpg", 
	  "../../assets/img/algorithm/01000.jpg", 
	  "../../assets/img/algorithm/01001.jpg", 
	  "../../assets/img/algorithm/01010.jpg", 
	  "../../assets/img/algorithm/01011.jpg", 
	  "../../assets/img/algorithm/01100.jpg", 
	  "../../assets/img/algorithm/01101.jpg", 
	  "../../assets/img/algorithm/01110.jpg", 
	  "../../assets/img/algorithm/01111.jpg", 
	  "../../assets/img/algorithm/10000.jpg", 
	  "../../assets/img/algorithm/10001.jpg", 
	  "../../assets/img/algorithm/10010.jpg", 
	  "../../assets/img/algorithm/10011.jpg", 
	  "../../assets/img/algorithm/10100.jpg", 
	  "../../assets/img/algorithm/10101.jpg", 
	  "../../assets/img/algorithm/10110.jpg", 
	  "../../assets/img/algorithm/10111.jpg", 
	  "../../assets/img/algorithm/11000.jpg", 
	  "../../assets/img/algorithm/11001.jpg", 
	  "../../assets/img/algorithm/11010.jpg", 
	  "../../assets/img/algorithm/11011.jpg", 
	  "../../assets/img/algorithm/11100.jpg", 
	  "../../assets/img/algorithm/11101.jpg", 
	  "../../assets/img/algorithm/11110.jpg", 
	  "../../assets/img/algorithm/11111.jpg", 
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
  setInterval(changeImage, 125); // 1.25초마다 이미지 변경

  // 페이지 로드 시 이미지 로딩
  window.onload = loadImages;
  

    // 3초 후에 result.jsp로 이동하는 함수
    function moveToResult() {
        setTimeout(function () {
            location.href = "/algorithm/result.ag";
        }, 5000); // 5초 후에 result.ag로 이동
    }


    // 페이지가 로드될 때 실행되는 함수
    window.onload = function () {
        moveToResult(); // 3초 후에 result.jsp로 이동
    }

