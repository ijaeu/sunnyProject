
let $fileInput = $('#file');
let $fileList = $(".file-list");
let $cnt = $('cnt');

console.log($fileInput);

$fileInput.on('change', function() {
	let files = this.files;
	console.log(files);

	if (files.length > 1) {
		let dt = new DataTransfer();
		alert("커버사진은 1개만 선택 가능합니다.")
		return;
	}

	for (let i = 0; i < files.length; i++) {
		let src = URL.createObjectURL(files[i]);

		$fileList.append(`
				<li>
					<div class="preview-img-box">
						<img src=${src}>
					</div>
					<div class="delete-button">
						<button type='button' class="delete-button" data-name="${files[i].name}">삭제</button>
					</div>
				</li>
			`);
	}

	$('.delete-button').on('click', function() {
		$(this).parent().parent().remove();
		let fileName = $(this).data('name');
		let dt = new DataTransfer();

		for (let i = 0; i < files.length; i++) {
			if (files[i].name !== fileName) {
				dt.items.add(files[i]);
			}
		}
		files = dt.files;
	});
});

let $fileInput2 = $('#file2');
let $fileList2 = $(".file-list2");
let $cnt2 = $('cnt2');

console.log($fileInput2);

$fileInput2.on('change', function() {
	let files = this.files;
	console.log(files);

	if (files.length > 1) {
		let dt = new DataTransfer();
		alert("내용사진은 1개씩만 첨부 가능합니다.")
		return;
	}

	for (let i = 0; i < files.length; i++) {
		let src = URL.createObjectURL(files[i]);

		$fileList2.append(`
	            <div>
	                <div class="preview-img-box">
	                    <img src=${src}>
	                </div>
	                <div class="delete-button">
	                    <button type='button' class="delete-button" data-name="${files[i].name}">삭제</button>
	                </div>
	            </div>
	        `);
	}



	$('.delete-button').on('click', function() {
		$(this).parent().parent().remove();
		let fileName = $(this).data('name');
		let dt = new DataTransfer();

		for (let i = 0; i < files.length; i++) {
			if (files[i].name !== fileName) {
				dt.items.add(files[i]);
			}
		}
		files = dt.files;
	});
});


//취소 버튼 레츠기릿
$('.cancel-btn').on('click', () => {
	window.location.href = '/story/storyListOk.st';
});

$(document).ready(function() {
	$("#summernote").summernote({
		height: 250,
		lang: "ko-KR",
		toolbar: [
			["style", ["style"]],
			["font", ["bold", "italic", "underline", "clear"]],
			["fontname", ["fontname"]],
			["color", ["color"]],
			["para", ["ul", "ol", "paragraph"]],
		],
		placeholder: "*스토리 내용을 입력해주세요!",
	});
});

$(document).ready(function() {
	$("#summernote2").summernote({
		height: 250,
		lang: "ko-KR",
		toolbar: [
			["style", ["style"]],
			["font", ["bold", "italic", "underline", "clear"]],
			["fontname", ["fontname"]],
			["color", ["color"]],
			["para", ["ul", "ol", "paragraph"]],
		],
		placeholder: "*스토리 내용을 입력해주세요!",
	});
});

$(document).ready(function() {
	$("#summernote3").summernote({
		height: 250,
		lang: "ko-KR",
		toolbar: [
			["style", ["style"]],
			["font", ["bold", "italic", "underline", "clear"]],
			["fontname", ["fontname"]],
			["color", ["color"]],
			["para", ["ul", "ol", "paragraph"]],
		],
		placeholder: "*스토리 내용을 입력해주세요!",
	});
});



$(document).ready(function() {
	// DOM이 로드된 후 실행되는 코드
	var addBtn = $(".add-btn");
	var storyContentBox2 = $(".storyContent-box2");
	var storyContentBox3 = $(".storyContent-box3");
	var deleteBtn = $(".content-delete");

	addBtn.on("click", function() {
		if (storyContentBox2.is(":hidden")) {
			storyContentBox2.show();
		} else if (storyContentBox3.is(":hidden")) {
			storyContentBox3.show();
			addBtn.hide();
		}
	});

deleteBtn.on("click", function() {
    // 입력 내용 초기화
    $("#content").val("");

    // 부모 요소 숨기기
    if (!storyContentBox2.is(":hidden")) {
        storyContentBox2.hide();
    } else if (!storyContentBox3.is(":hidden")) {
        storyContentBox3.hide();
    }

    // addBtn 보이기
    addBtn.show();
});


});



$("#file3").on("change", function() {
    var files = this.files;
    if (files.length > 1) {
        alert("내용사진은 1개씩만 첨부 가능합니다.");
        return;
    }
    var file = files[0];
    var src = URL.createObjectURL(file);
    $(".file-list3").html(`
        <li class="preview-img-box">
            <img src="${src}">
<button type="button" class="delete-button" data-file-index="0">삭제</button>
        </li>
    `);
    $(".cnt3").text(1);
});


$("#file4").on("change", function() {
    var files = this.files;
    if (files.length > 1) {
        alert("내용사진은 1개씩만 첨부 가능합니다.");
        return;
    }
    var file = files[0];
    var src = URL.createObjectURL(file);
    $(".file-list4").html(`
        <li class="preview-img-box">
            <img src="${src}">
<button type="button" class="delete-button" data-file-index="0">삭제</button>
        </li>
    `);
    $(".cnt4").text(1);
});


$(".file-list3").on("click", ".delete-button", function() {
    // 이미지 미리보기 삭제
    $(".file-list3").html("");
    // 첨부한 파일 초기화
    $("#file3").val("");
    // 첨부한 파일 개수 초기화
    $(".cnt3").text("0");
});

$(".file-list4").on("click", ".delete-button", function() {
    // 이미지 미리보기 삭제
    $(".file-list4").html("");
    // 첨부한 파일 초기화
    $("#file4").val("");
    // 첨부한 파일 개수 초기화
    $(".cnt4").text("0");
});









