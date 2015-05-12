KISSY.use('core,xtemplate', function(S,Core,XTemplate) {
	var news='{{#each data}}'+
					 '<p class="item">'+
						 '<a class="name" href="announce-detail.html?id={{id}}">{{title}}</a>'+
						 '<span class="time">{{date}}</span>'+
					 '</p>'+
				 '{{/each}}';
	
	
	function initPages(num){
		var n = num/10;
		var pages = '';
		if(num<10){
			pages += "<a href='#' data-id='1'>1</a>";
		}else{
			for(i=1;i<n+1;i++){
				if(i == 1){
					pages += "<a class='J_pagenum highlight' href='#' data-id="+i+">"+i+"</a>";
				}else{
					pages += "<a class='J_pagenum' href='#' data-id="+i+">"+i+"</a>";
				}
			}
		}
		pages= "<a class='prev J_prev' href='#' hidden>< Prev</a>"+pages+"<a class='next J_next' href='#'>Next ></a>";
		S.one(".pages").html(pages);
	}
	
	function init(mydata,pageNum){
		
		var prev = S.one(".J_prev");
		var next = S.one(".J_next");
		pageNum = pageNum?pageNum-1:0;
		if(pageNum>0){
			prev.show();
		}else{
			prev.hide();
		}
		
		if(pageNum < mydata.length/10-1){
			next.show();		
		}else{
			next.hide();
		}
		
		var data1={};
		data1.data=mydata.slice(pageNum*10,pageNum*10+10);
		 var render = new XTemplate(news).render(data1);
         S.one(".J_contain").html(render);
	};
	  KISSY.IO({
	        url : "http://localhost:8080/robotmessage/getAnnouncement",
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
	    		}
	        	
	        	initPages(len);
	        	init(data);
		        
		        var pages = S.one(".pages");
		        pages.delegate("click",".J_pagenum",function(e){
		        	var target=S.one(e.target);
		        	pages.all(".J_pagenum").removeClass("highlight");
		        	target.addClass("highlight");
		        	var num = target.attr("data-id");
		        	init(data,num);
		        });
		        
		        pages.delegate("click",".J_prev",function(){
		        	var nowPage = S.one(".highlight");
		        	var nownum = nowPage.attr("data-id");
		        	nowPage.prev("a").addClass("highlight");
		        	nowPage.removeClass("highlight");
		        	init(data,nownum-1);
		        });
		        
		        pages.delegate("click",".J_next",function(){
		        	var nowPage = S.one(".highlight");
		        	var nownum = nowPage.attr("data-id");
		        	nowPage.next("a").addClass("highlight");
		        	nowPage.removeClass("highlight");
		        	init(data,1+parseInt(nownum));
		        });
	        	
	           
	        }
	  });
});
