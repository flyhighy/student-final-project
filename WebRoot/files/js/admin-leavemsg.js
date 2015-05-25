KISSY.use('core,xtemplate', function(S,Core,XTemplate) {
	var alldata=[];
	var searchData=[];
	var tpl = '{{#each data}}'+
				'<p class="news-item">'+
					'<span class="choose">'+
						'<input name="checkOption" class="choose-box" type="checkbox" value="{{id}}"> </span>'+
						'<span class="news-title">{{this.name}}</span>'+
						'<span class="operator"><a href="leaveMsgDetail?message.id={{id}}">查看</a>|<a href="delLeaveMsg?message.id={{id}}">删除</a></span>'+
//						'<span class="author">{{department}}</span>'+ 
						'<span class="click-num">{{date}}</span>'+
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
        var render = new XTemplate(tpl).render(data1);
        S.one(".J_apply").html(render);
	};
	
	

	KISSY.IO({
		url : "../robotmessage/getLeaveMsgs",
		type : "post",
		dataType:'json',
	    contentType:false,
		success : function(data) {
			
			
			for(i=0;i<data.length;i++){
				if(data[i].time){
					var date=new Date();
	    			date.setTime(data[i].time.time);
	    			var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
	    			data[i].date = time;
				}				
				alldata.push(data[i]);
			}
			
	        initPages(data.length);
	        init(data);
	        
	        var pages = S.one(".pages");
	        pages.delegate("click",".J_pagenum",function(e){
	        	var target=S.one(e.target);
	        	pages.all(".J_pagenum").removeClass("highlight");
	        	target.addClass("highlight");
	        	var num = target.attr("data-id");
	        	init(alldata,num);
	        });
	        
	        pages.delegate("click",".J_prev",function(){
	        	var nowPage = S.one(".highlight");
	        	var nownum = nowPage.attr("data-id");
	        	nowPage.prev("a").addClass("highlight");
	        	nowPage.removeClass("highlight");
	        	init(alldata,nownum-1);
	        });
	        
	        pages.delegate("click",".J_next",function(){
	        	var nowPage = S.one(".highlight");
	        	var nownum = nowPage.attr("data-id");
	        	nowPage.next("a").addClass("highlight");
	        	nowPage.removeClass("highlight");
	        	init(alldata,1+parseInt(nownum));
	        });
		}
	});
	
	
	var body = S.one("body");

	
	
	
	var flag = true;
	var checkAll = true;

	body.delegate("click", ".checkedmore", function() {
		if (flag) {
			body.one(".checkedmore").attr("value", "退出操作");
			body.one(".delmore").css("display", "block");
			body.one(".head-choose").css("display", "inline-block");
			body.all(".choose").css("display", "inline-block");
			flag = false;
		} else {
			body.one(".checkedmore").attr("value", "批量操作");
			body.one(".delmore").css("display", "");
			body.one(".head-choose").css("display", "");
			body.all(".choose").css("display", "");
			flag = true;
		}
	});

	body.delegate("click", ".check-all", function() {
		if (checkAll) {
			body.all(".choose-box").prop("checked", true);
			checkAll = false;
		} else {
			body.all(".choose-box").prop("checked", false);
			checkAll = true;
		}
	});

	body.delegate("click", ".del-many", function() {
		document.getElementById("delMany").submit();
	});
	
});