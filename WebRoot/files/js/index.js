/**
 * Created by fly on 2015/4/23.
 */
KISSY.use("core,io,xtemplate",function(S,Core,IO,XTemplate){
    var secondBox = S.one(".J_secondBox");
    secondBox.delegate("click",".J_navItem",function(e){
        var target = S.one(e.target);
        secondBox.all(".J_navItem").removeClass("active");
        target.addClass("active");
        var index = target.attr("data");
        secondBox.all(".news").hide();
        if(index == 0){
        	secondBox.one(".J_news").show();
        }else if(index == 1){
        	secondBox.one(".J_announcement").show();
        }else{
        	secondBox.one(".J_shortdec").show();
        }
    });

    KISSY.IO({
        url : "../robotmessage/getHeadnews",
        type : "post",
        dataType:'json',
        contentType:false,
        success : function(data) {
           
            var len = data.length;
            var links=[];
            for(i=0;i<len;i++){
            	var img = data[i].image;
            	var start = img.indexOf('src=');
            	var end = img.indexOf('"',start+5);
            	var link =img.substring(start+5,end);
            	links.push(link);
            }
            
            var imgNews = S.one("#imgNews");
            var triggers = imgNews.all(".trigger-item");
            var img = imgNews.one(".J_img");
            var imgLink = imgNews.one(".J_imgLink");
            img.attr("src",links[0]);
            img.attr("title",data[0].title);
            imgLink.attr("href","../robotmessage/files/user-page/headnews-detail.html?id="+data[0].id);
            S.one(triggers[0]).addClass("highlight");
            var nowImg = 0;
            timer = setInterval(function(){            	
            	 nowImg = (nowImg+1)%5;
            	 img.attr("src",links[nowImg]);
            	 img.attr("title",data[nowImg].title);
            	 imgLink.attr("href","../robotmessage/files/user-page/headnews-detail.html?id="+data[nowImg].id);
            	 triggers.removeClass("highlight");
            	 S.one(triggers[nowImg]).addClass("highlight");
            },2000);
            
//            imgNews.delegate("mouseenter",".J_img",function(){
//            	timer=null;
//            });
//            
//            imgNews.delegate("mouseleave",".J_img",function(){
//             	timer = setInterval(function(){
//                	 nowImg = (nowImg+1)%5;
//                	 img.attr("src",links[nowImg]);
//                	 img.attr("title",data[nowImg].title);
//                	 triggers.removeClass("highlight");
//                	 S.one(triggers[nowImg]).addClass("highlight");
//                },2000);
//             });
            
            
            imgNews.delegate("click",".trigger-item",function(e){
            	var target = S.one(e.target);
            	var index = target.index();
            	nowImg=index;
            	img.attr("src",links[index]);
                img.attr("title",data[index].title);
                triggers.removeClass("highlight");
                target.addClass("highlight");
            });         
        }
    });
    
    var news = '{{#each data}}'+
				   '<a href="../robotmessage/files/user-page/news-detail.html?id={{id}}" class="news-item clearfix">'+
				   '<span class="news-title">{{this.title}}</span>'+
				   '<span class="news-time clearfix">{{this.date}}</span>'+
				   '</a>'+				   
    		  '{{/each}}'+
    		  '<div class="more"> <a href="../robotmessage/files/user-page/news.html">更多></a></div>';
    
    KISSY.IO({
        url : "../robotmessage/newsPages",
        type : "post",
        dataType:'json',
        contentType:false,
        success : function(data){
        	var data1={};
    		data1.data=data.slice(0,6);
    		for(i=0;i<6;i++){
    			var date=new Date();
    			date.setTime(data1.data[i].time.time);
    			var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
    			data1.data[i].date = time;
    		}
            var render = new XTemplate(news).render(data1);
            S.one(".J_news").html(render).show();

    	}
    });
    
    var announcement = '{{#each data}}'+
		   '<a href="../robotmessage/files/user-page/announce-detail.html?id={{id}}" class="news-item clearfix">'+
		   '<span class="news-title">{{this.title}}</span>'+
		   '<span class="news-time clearfix">{{this.date}}</span>'+
		   '</a>'+				   
	   '{{/each}}'+
	   '<div class="more"> <a href="../robotmessage/files/user-page/announcement.html">更多></a></div>';
    
    KISSY.IO({
        url : "../robotmessage/getAnnouncement",
        type : "post",
        dataType:'json',
        contentType:false,
        success : function(data){
        	var len = data.length>6?6:data.length;
        	var data1={};
    		data1.data=data.slice(0,6);
    		for(i=0;i<len;i++){
    			var date=new Date();
    			date.setTime(data1.data[i].time.time);
    			var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
    			data1.data[i].date = time;
    		}
            var render = new XTemplate(announcement).render(data1);
            S.one(".J_announcement").html(render);

    	}
    });
    
    var hotnews = '{{#each data}}'+
					    '<a href="../robotmessage/files/user-page/news-detail.html?id={{id}}">'+
					    '<span class="news-title">{{this.title}}</span>'+
					    '<span class="news-time clearfix">{{this.date}}</span>'+
					    '</a>'+
				    '{{/each}}';
    KISSY.IO({
        url : "../robotmessage/gethotNews",
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
            var render = new XTemplate(hotnews).render(data1);
            S.one(".J_hotItem").html(render);

    	}
    });
    
   // var shortDec = '{{data}}';
    
    
    KISSY.IO({
        url : "../robotmessage/getShortdec",
        type : "post",
        dataType:'',
        contentType:false,
        success : function(data){
        //	var render = new XTemplate(hotnews).render(data);
        	var contain = '<div class="shortdec">'+data+'</div>'+'<div class="more"> <a href="../robotmessage/files/user-page/shortdec.html">更多></a></div>';
            S.one(".J_shortdec").html(contain);
    	}
    });
    
    var hotBox = S.one(".J_hotItem");
    var top=0;
    var timer1 = setInterval(function(){
    	var height = hotBox.height();
    	hotBox.css("top",top--);
    	if((height+top)<300){
    		top=0;
    	}
    },100);
    
    
    var achievement = '{{#each data}}'+
	   '<a href="../robotmessage/files/user-page/achievement-detail.html?id={{id}}" class="news-item clearfix">'+
	   '<span class="news-title">{{this.name}}</span>'+
	   '<span class="news-time clearfix">{{this.date}}</span>'+
	   '</a>'+				   
	   '{{/each}}'+
	   '<div class="more"> <a href="../robotmessage/files/user-page/achievement.html">更多></a></div>';

		KISSY.IO({
		 url : "../robotmessage/getAchievements",
		 type : "post",
		 dataType:'json',
		 contentType:false,
		 success : function(data){
		 	var len = data.length>7?7:data.length;
		 	var data1={};
				data1.data=data.slice(0,7);
				for(i=0;i<len;i++){
					var date=new Date();
					date.setTime(data1.data[i].time.time);
					var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
					data1.data[i].date = time;
				}
		     var render = new XTemplate(achievement).render(data1);
		     S.one(".J_honorItem").html(render);
		
			}
		});
		
		
		
		var competition = '{{#each data}}'+
		   '<a href="../robotmessage/files/user-page/competition-detail.html?id={{id}}" class="news-item clearfix">'+
		   '<span class="news-title">{{this.name}}</span>'+
		   '<span class="news-time clearfix">{{this.date}}</span>'+
		   '</a>'+				   
		   '{{/each}}'+
		   '<div class="more"> <a href="../robotmessage/files/user-page/competition.html">更多></a></div>';

			KISSY.IO({
			 url : "../robotmessage/getCompetitions",
			 type : "post",
			 dataType:'json',
			 contentType:false,
			 success : function(data){
			 	var len = data.length>7?7:data.length;
			 	var data1={};
					data1.data=data.slice(0,7);
					for(i=0;i<len;i++){
						var date=new Date();
						date.setTime(data1.data[i].time.time);
						var time = date.getFullYear() + '-' +(date.getMonth()+1)+'-'+date.getDay();
						data1.data[i].date = time;
					}
			     var render = new XTemplate(competition).render(data1);
			     S.one(".J_competitionItem").html(render);
			
				}
			});
    
    
});