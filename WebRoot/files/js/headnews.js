KISSY.use('core,xtemplate', function(S,Core,XTemplate) {
	
	var tpl = '{{#each data}}'+
				'<li class="news-item">'+
					'<a class="news-link" href="http://localhost:8080/robotmessage/files/user-page/headnews-detail.html?id={{id}}" target="_parent">'+
						'<img class="img-wrapper" src="{{{link}}}"></img>'+
					    '<div class="news-msg">'+
					        '<div class="msg-item">{{title}}</div>'+
					        '<div class="msg-item"><span>作者：</span><span>{{author}}</span></div>'+
					        '<div class="msg-time">{{time}}</div>'+
					    '</div>'+
					 '</a>'+
				'</li>'+
			    '{{/each}}';

  	var url ="http://localhost:8080/robotmessage/getHeadnews";
	  KISSY.IO({ 
	        url : url,
	        type : "post",
	        dataType:'json',
	        contentType:false,
	        success : function(data){
	        	var data1 ={};
	        	data1.data = data.slice(0,2);
	        	for(i = 0;i<2;i++){
	        		
	        		var img = data[i].image;
	            	var start = img.indexOf('src=');
	            	var end = img.indexOf('"',start+5);
	            	var link =img.substring(start+5,end);
	            	data1.data[i].link = link;
	            	
		        	var date=new Date();
	    			date.setTime(data1.data[i].time.time);
	    			var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
	    			data1.data[i].time = time;
    			}
	        	var render = new XTemplate(tpl).render(data1);
	        	S.one(".J_headnews").html(render);
	        	}
	  });
});
