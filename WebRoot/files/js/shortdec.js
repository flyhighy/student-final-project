KISSY.use('core', function(S,Core) {
  	var url1 ="http://localhost:8080/robotmessage/getShortdec";
	  KISSY.IO({ 
	        url : url1,
	        type : "post",
	        dataType:'',
	        contentType:false,
	        success : function(data){      
	        	S.one(".J_content").html(data);
	        	}
	  });
});
