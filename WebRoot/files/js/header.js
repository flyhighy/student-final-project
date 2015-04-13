KISSY.use("core,io",function(S,Core,IO){
	KISSY.IO({
		url : "http://wanghengfei:8080/robotmessage/getPageMsg",
		type : "post",
		dataType:'json',
	    contentType:false,
		success : function(data) {
			var nowNav = data[1];
			var user = data[0];
			var nav = S.one(".J_nav");
			var items = S.all(".item");
			items.removeClass("active");
			S.one(items[nowNav-1]).addClass("active");
			nav.one(".J_user").html(user.name);
		}
	});
});