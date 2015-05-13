window.onload=function(){
		 var doc;
		 if (document.all){ // IE 
		  doc = document.frames[0].document; 
		 }else{ // 标准
		  doc = document.getElementsByTagName("iframe")[0].contentDocument; 
		 }
		 
		 var item = doc.getElementsByClassName("item");
		 var len = item.length;
		 for(i = 0;i<len;i++){
		 	item[i].setAttribute("class","item");
		 }
	 }