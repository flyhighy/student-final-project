KISSY.use('core,xtemplate', function(S,Core,XTemplate) {
	var alldata=[];
	var searchData=[];
	var tpl = '{{#each data}}'+
				'<p class="news-item">'+
					'<span class="choose">'+
						'<input name="checkOption" class="choose-box" type="checkbox" value="{{id}}"> </span>'+
						'<a class="news-title"	href="newsDetail?news.id={{id}}">{{this.title}}</a>'+
						'<span class="operator"><a href="editNews?news.id={{id}}">编辑</a>|<a href="delNews?news.id={{id}}">删除</a></span>'+
						'<span class="author">{{author}}</span>'+ 
						'<span class="click-num">{{number}}</span>'+
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
        S.one(".J_news").html(render);
	};
	
	

	KISSY.IO({
		url : "http://localhost:8080/robotmessage/newsPages",
		type : "post",
		dataType:'json',
	    contentType:false,
		success : function(data) {
			for(i=0;i<data.length;i++){
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
	body.delegate("click",".J_search",function(){
		var serachOption = body.one(".J_searchOption").val();
		KISSY.IO({
			url : "http://localhost:8080/robotmessage/searchNews?searchOption="+serachOption,
			type : "post",
			dataType:'json',
		    contentType:false,
			success : function(data) {
				for(i=0;i<data.length;i++){
					searchData.push(data[i]);
				}
				
		        initPages(data.length);
		        init(data);
		        
		        var pages = S.one(".pages");
		        pages.undelegate("click",".J_pagenum");
		        pages.undelegate("click",".J_prev");
		        pages.undelegate("click",".J_next");
		        
		        pages.delegate("click",".J_pagenum",function(e){
		        	var target=S.one(e.target);
		        	pages.all(".J_pagenum").removeClass("highlight");
		        	target.addClass("highlight");
		        	var num = target.attr("data-id");
		        	init(searchData,num);
		        });
		        
		        pages.delegate("click",".J_prev",function(){
		        	var nowPage = S.one(".highlight");
		        	var nownum = nowPage.attr("data-id");
		        	nowPage.prev("a").addClass("highlight");
		        	nowPage.removeClass("highlight");
		        	init(searchData,nownum-1);
		        });
		        
		        pages.delegate("click",".J_next",function(){
		        	var nowPage = S.one(".highlight");
		        	var nownum = nowPage.attr("data-id");
		        	nowPage.next("a").addClass("highlight");
		        	nowPage.removeClass("highlight");
		        	init(searchData,1+parseInt(nownum));
		        });
			}
		});
	});
	
	
	
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