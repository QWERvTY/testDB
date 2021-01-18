<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TEST!</title>
<script type="text/javascript" src="/js/jquery-1.12.4.min.js"></script>
</head>
<body>
<button id="select">SELECT</button>
<button id="insert">INSERT</button>
<div id="data">
<input type="text" name="id" >
<input type="text" name="name" >
<input type="text" name="location" >
<input type="date" name="data" >
</div>
<div id="result"></div>
</body>
<script type="text/javascript">
$(document).ready(function() {
	var $result	= $('#result');
	var $data	= $('#data');
	
	$('#select').click(function() {
		console.log('SELECT!');
// 		var data 	= inpToData();
		var getData	= {
			'uri'		: '/getUser',
			'method'	: 'POST'
		}
		
		ajaxCall(getData);
	});
	
	$('#insert').click(function() {
		console.log('INSERT!');
		var data 	= inpToData();
		var getData	= {
			'uri'		: '/getUser',
			'method'	: 'POST',
			'data'		: data
		}
		
		ajaxCall(getData);
	});
	
	

	function ajaxCall(inp) {
		$.ajax({
			url			: inp.uri
			,type		: inp.method
			,data		: inp.data
			,dataType	: 'text'
			,success	: function(data){
				console.log('success ' + data);
				$result.html(data);
			}
			,error		: function(xhr, status, error){
				console.log(xhr);
				console.log(xhr.status+', '+status+'\n'+error);
			}
		});
	}

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

});

</script>
</html>