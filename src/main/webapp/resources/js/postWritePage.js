$(document).ready(function(){
	var query = {
			post_code : $('#post_code').val(),
			id : ""
	}
	
	if( query.post_code != "") { // 게시글 수정을 누르고 들어왔을 때
		 $.ajax({
	        url: "/board/postPage/",
	        type: "GET",
	        dataType: "json",
	        data: query,
	        success : function(data){
	        	console.log(data.result[0].post_title);
	            $('#post_title').val(data.result[0].post_title);
	            $('#post_content').append(data.result[0].post_content);
	            
	            query.id = data.result[0].id; // update를 위해 저장
	        }
		}); // ajax END
		 
		 // 게시글 수정 상태에서 작성완료 button click
		 $('#registerPost').click(function() {
			 query.board_code = $('#board_code').val(),
			 query.post_title = $('#post_title').val(),
			 query.post_content = $('#post_content').val()
			
			$.ajax({
		    	url: "/board/updatePost",
		    	type: "POST",
		    	data : query,
		    	dataType: "json", // controller return을 json으로 받음
		    	success : function(data){
		    		console.log(data);
		    		$(location).attr('href', '/board/viewMainPost');
		    	}, error: function(data) {
		    		console.log(data);
		    	}
			});
		});
	} else {
		 // 글쓰기 상태에서 작성완료 button click
		$('#registerPost').click(function() {
			var query =  {
				board_code : $('#board_code').val(),
				post_title : $('#post_title').val(),
				post_content : $('#post_content').val()
			};
			
			$.ajax({
		    	url: "/board/insertPost",
		    	type: "POST",
		    	data : query,
		    	dataType: "json", // controller return을 json으로 받음
		    	success : function(data){
		    		console.log("??");
		    		$(location).attr('href', '/board/viewMainPost');
		    	}, error: function(data) {
		    		console.log(data);
		    	}
			});
		});
	}
	
	$('#postCancel').click(function() {
		$(location).attr('href', '/board/viewMainPost');
	})
});