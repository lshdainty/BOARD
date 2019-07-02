$(document).ready(function(){

//	jsp페이지가 load되면 controller로부터 게시판 list를 불러와 화면에 출력
	$.ajax({
    	url: "/board/postList",
    	type: "GET",
    	dataType: "json", // controller return을 json으로 받음
    	success : function(data){
    		var tbody = $('#tbody');
    		var html = ""; // jsp에 추가할 html코드 : 게시글 한개
    		for( var i = 0; i < data.result.length; i++) {
    			html += '<tr class="tbody_tr">' +
                			'<td>'+data.result[i].post_code+'</td>' +  
                			'<td>'+data.result[i].post_title+'</td>' + 
                			'<td>'+data.result[i].id+'</td>' + 
                			'<td>'+new Date(data.result[i].post_date.time).format("yyyy-MM-dd")+'</td>' + // Date는 ajax로 넘어올때 밀리세컨드로 넘어와서 format을 변경해야함 
                		'</tr>';
    		}
    		tbody.append(html); // tbody태그에 추가
    	}, error: function(data) {
    		console.log(data);
    	}
    }); // ajax END
	
//	글쓰기 버튼 클릭
	$('#writePost').click(function() {
		$(location).attr('href', '/board/viewWritePage');
	})
	
//	게시글 하나를 클릭
	$(document).on('click', '.tbody_tr', function() { // $(document).on : 회면을 새로읽음
		var post_code = $(this).find('td:eq(0)').text().trim(); // 선택한 게시글의 post code

		$(location).attr('href', '/board/viewPostPage?post_code='+ post_code);
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