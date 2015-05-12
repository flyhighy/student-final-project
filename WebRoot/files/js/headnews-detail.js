KISSY.use('core,xtemplate', function(S,Core,XTemplate) {
	
	var tpl = '<div class="news-msg">'+
				'<h3>{{title}}</h3>'+
				'<span class="title-item">'+
					'<span>作者:{{author}}</span>'+
				'</span>'+
				'<span class="title-item">'+
					'<span>来源:{{source}}</span>'+
				'</span>'+
				'<span class="title-item">'+
					'<span>时间:{{time}}</span>'+
				'</span>'+
				'</div>'+
			'<div class=" content-detail">{{{content}}}</div>';

 	var search = location.search;
  	var id = search.split("=")[1];
  	var url ="http://localhost:8080/robotmessage/headNewsDetail?headnews.id="+id;
	  KISSY.IO({ 
	        url : url,
	        type : "post",
	        dataType:'json',
	        contentType:false,
	        success : function(data){
	        	var date=new Date();
    			date.setTime(data[0].time.time);
    			var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
    			data[0].time = time;
	        	var render = new XTemplate(tpl).render(data[0]);
	        	S.one(".J_content").html(render);
	        	}
	  });
});
