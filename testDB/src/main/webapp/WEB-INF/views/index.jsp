<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST!</title>
<script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
<style type="text/css">
#content{
	width: 720px;
	margin: auto;
}
table {
	border: 1px solid #333;
	width: 720px;
	text-align: center;
	padding: 1rem;
}
input {
	width: 80%;
}
button {
	border-radius: 3px;
	border: 1px solid #bbb;
	background-color: #3388EE;
	color: #FFF;
	margin: 1rem;
	width: 80px;
	height: 40px;
}
td{
	height: 50px;
}
#result{
	margin-top: 50px;
}
.hide{
	display: none;
}
</style>
</head>
<body>
<div id="content">
<button id="select">SELECT</button>
<button id="insert">INSERT</button>
<table>
<colgroup>
	<col width="150">
	<col width="150">
	<col width="150">
	<col width="150">
</colgroup>
<thead>
	<tr>
		<th scope="col">ID</th>
		<th scope="col">NAME</th>
		<th scope="col">지역</th>
		<th scope="col">생년월일</th>
	</tr>
</thead>
<tbody id="data">
	<tr>
		<td><input type="text" name="id" required="required"></td>
		<td><input type="text" name="name" required="required"></td>
		<td><input type="text" name="location"></td>
		<td><input type="date" name="birthday"></td>
	</tr>
</tbody>
</table>
<div id="result" class="hide">
<table>
<colgroup>
	<col width="50">
	<col width="140">
	<col width="140">
	<col width="140">
	<col width="140">
</colgroup>
<thead>
<tr><th colspan="5">USER</th></tr>
</thead>
<tbody id="resultBody"></tbody>
</table></div>
</div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	var $result	= $('#result');
	var $data	= $('#data');
	
	$('#select').click(function() {
		console.log('SELECT!');
		var getData	= {
			uri		: '/getUser',
			method	: 'POST',
			fn		: displayData
		}
		
		ajaxCall(getData);
	});
	
	$('#insert').click(function() {
		console.log('INSERT!');
		var data 	= inpToData();
		var getData	= {
			uri		: '/insertUser',
			method	: 'POST',
			data	: data,
			fn		: function(data) {
				if (data == 0){
					console.log('ID 중복!');
					alert('ID가 이미 존재합니다!' + data);
				}else{
					alert('입력완료!' + data);
					
				}
			}
		}
		
		$result.addClass('hide');
		ajaxCall(getData);
	});
	
	
	function inpToData() {
		var data	= {};
		var name	= null;
		var value	= null;
		var $this	= null;
		
		$data.find('input').each(function() {
			$this	= $(this);
			name 	= $this.attr('name');
			value	= $this.val();
			
			data[name]	= value;
		});
		
		console.log('data = ' + JSON.stringify(data));
		
		return data;
	}

	function ajaxCall(inp) {
		$.ajax({
			url			: inp.uri
			,type		: inp.method
			,data		: inp.data
			,dataType	: 'text'
			,success	: function(data){
				console.log('success ' + data);
				inp.fn(data);
			}
			,error		: function(xhr, status, error){
				console.log(xhr);
				console.log(xhr.status+', '+status+'\n'+error);
			}
		});
	}
	
	function displayData(jsonData) {
		var $tr 		= $('<tr>');
		var $th 		= $('<th>');
		var $td 		= $('<td>');
		var $trClone;
		var date 		= '';
		
		var no			= 0;
		var $resultBody = $('#resultBody').empty();
		var data 		= JSON.parse(jsonData);
		$result.removeClass('hide');
		
		$.each(data, function(i, v){
			$trClone	= $tr.clone().appendTo($resultBody);
			date = v.birthday;
			
			$th.clone().html(++no).appendTo($trClone);
			$td.clone().html(v.id).appendTo($trClone);
			$td.clone().html(v.name).appendTo($trClone);
			$td.clone().html(v.location).appendTo($trClone);
			$td.clone().html(dateFormat(date)).appendTo($trClone);
			
		});
		
	}
	
	function dateFormat(paramDate) {
		var date 	= new Date(paramDate);
		
		var year	= date.getFullYear();
		var month	= date.getMonth()+1;
		var date	= date.getDate();
		
		return year+'-'+select(month)+'-'+select(date);
	}
	
	function select(num) {		// 두 자리 자릿수 맞추기
		if (num < 10) {
			return '0' + num;
		} else {
			return num;
		}
	}
	


});

</script>
</html>