$(document).ready(function(){
	
	$("#logIn").click(function(){
		
		var query = {id:$("#id").val(), password:$("#password").val()};
		
	    $.ajax({
	    	url: "/board/",
	    	type: "POST",
	    	dataType: "json",
	    	data: query,
	    	success : function(data){
	    		if(data.result == "1"){
	    			alert("아이디가 없습니다.");
	    		}else if(data.result == "2"){
	    			alert("비밀번호가 틀렸습니다.");
	    		}else{
	    			window.location.href = "/board/viewMainPost";
	    		}
	    	}
	    }); // ajax END
	});

});