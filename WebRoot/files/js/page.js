KISSY.use('core,xtemplate', function(S,Core,XTemplate) {
	var download='{{#each data}}'+
					 '<p class="item">'+
						 '<a class="name" href="{{href}}">{{name}}</a>'+
						 '<span class="time">{{date}}</span>'+
					 '</p>'+
				 '{{/each}}';
	  KISSY.IO({
	        url : "http://wanghengfei:8080/robotmessage/getDownload",
	        type : "post",
	        dataType:'json',
	        contentType:false,
	        success : function(data){
	        	var len = data.length;
	        	var data1={};
	    		data1.data=data;
	        	for(i=0;i<len;i++){
	    			var date=new Date();
	    			date.setTime(data1.data[i].time.time);
	    			var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
	    			data1.data[i].date = time;
	    			
	    			var path = data1.data[i].path;
	    			var start = path.indexOf('href=');
	            	var end = path.indexOf('"',start+6);
	            	data1.data[i].href = data1.data[i].path.substring(start+6,end);
	    		}
	            var render = new XTemplate(download).render(data1);
	            S.one(".J_contain").html(render);
	        }
	  });
});
