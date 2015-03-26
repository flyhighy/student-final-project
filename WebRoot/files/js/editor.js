KindEditor.ready(function(K) {
	 editor1 = K.create('textarea[name="content1"]', {
		cssPath : 'robotmessage/kindeditor/plugins/code/prettify.css',
		uploadJson : 'robotmessage/kindeditor/jsp/upload_json.jsp',
		fileManagerJson : 'robotmessage/kindeditor/jsp/file_manager_json.jsp',
		allowFileManager : true,
		afterBlur:function(){this.sync();},
		afterCreate : function() {
		}
	});
	prettyPrint();
});