$(document).ready(function(){
	var query = {
			post_code : $('#post_code').val(),
			id : ""
	};
	
	// post_code에 해당하는 게시글의 데이터를 db에서 가져와 화면에 출력
    $.ajax({
        url: "/board/postPage/",
        type: "GET",
        dataType: "json",// controller에서 return받는 data 타입을 json으로 함
        data: query,
        success : function(data){
        	console.log(data);
            $('#post_title').append(data.result[0].post_title);
            $('#id').append(data.result[0].id);
            $('#post_date').append(new Date(data.result[0].post_date.time).format("yyyy-MM-dd"));// Date는 ajax로 넘어올때 밀리세컨드로 넘어와서 format을 변경해야함
            $('#post_content').append(data.result[0].post_content);
            
            query.id = data.result[0].id; // controller에서 
        }
    }); // ajax END
    
//    게시글 삭제 버튼 클릭
    $('#delPost').click(function() {
    	$.ajax({
            url: "/board/deletePost/",
            type: "POST",
            dataType: "json",
            data: query,
            success : function(data){
            	$(location).attr('href', '/board/viewMainPost');
            }
        }); // ajax END
    })
    
//    게시글 수정 버튼 클릭
    $('#editPost').click(function() {
    	$(location).attr('href', "/board/viewWritePage?post_code="+ query.post_code);
    })
});

/*Date의 format을 변경해주는 메소드*/
Date.prototype.format = function(f) {
    if (!this.valueOf()) return " ";
 
    var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
    var d = this;
     
    return f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function($1) {
        switch ($1) {
            case "yyyy": return d.getFullYear();
            case "yy": return (d.getFullYear() % 1000).zf(2);
            case "MM": return (d.getMonth() + 1).zf(2);
            case "dd": return d.getDate().zf(2);
            case "E": return weekName[d.getDay()];
            case "HH": return d.getHours().zf(2);
            case "hh": return ((h = d.getHours() % 12) ? h : 12).zf(2);
            case "mm": return d.getMinutes().zf(2);
            case "ss": return d.getSeconds().zf(2);
            case "a/p": return d.getHours() < 12 ? "오전" : "오후";
            default: return $1;
        }
    });
};

String.prototype.string = function(len){var s = '', i = 0; while (i++ < len) { s += this; } return s;};
String.prototype.zf = function(len){return "0".string(len - this.length) + this;};
Number.prototype.zf = function(len){return this.toString().zf(len);};
/*Date format 변경 메소드 end*/