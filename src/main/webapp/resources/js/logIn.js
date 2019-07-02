$(document).ready(function(){
	
	$("#logIn").click(function(){ // 로그인 버튼 클릭
		
		var query = {id:$("#id").val(), password:$("#password").val()};
		
	    $.ajax({
	    	url: "/board/",
	    	type: "POST",
	    	dataType: "json", // controller에서 return받는 data 타입을 json으로 함
	    	data: query,
	    	success : function(data){
	    		if(data.result == "1"){
	    			alert("아이디가 없습니다.")   ;
	    		}else if(data.result == "2"){
	    			alert("비밀번호가 틀렸습니다.");
	    		}else{
	    			window.location.href = "/board/viewMainPost"; // 게시판 리스트 메인 페이지로 이동
	    		}
	    	}
	    }); // ajax END
	});

});