/**
 * board_write.js
 */
 
 $(document).ready(function() {
 
  $('#board_cont').summernote({
  		width:1080,
  		height: 400, // 에디터 높이
		minHeight: 300, // 최소 높이
		maxHeight: 500, // 최대 높이
		focus: true, // 에디터 로딩후 포커스를 맞출지 여부
		lang: 'ko-KR', // 한글 설정
		placeholder: '게시글 내용을 입력해 주세요',	//placeholder 설정
		 toolbar: [
			    // [groupName, [list of button]]
			    ['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']]
			  ],
			fontNames: ['맑은 고딕', '돋움', '궁서', '굴림', '굴림체', '궁서체', '나눔 고딕', '바탕', 
			'바탕체', '새굴림', 'HY견고딕', 'HY견명조', 'HY궁서B', 'HY그래픽M', 'HY목각파임B', 'HY신명조', 
			'HY얕은샘물M', 'HY엽서L', 'HY엽서M', 'HY중고딕', 'HY헤드라인M', '휴먼매직체', '휴먼모음T', '휴먼아미체',
			 '휴먼둥근헤드라인', '휴먼편지체', '휴먼옛체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28']
  });
});
