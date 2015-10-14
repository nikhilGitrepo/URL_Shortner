function loadRecentUrl() {
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url : 'getrecent.urlview',
		success : function(data) {
			$.each(data, function(i, item) {
				if (i == '@items') {
					var htmldiv = "";
					$.each(item, function(i, link) {
						htmldiv += "<ul><a href='" + link + "'>" + link + "</a></ul>";
					});
					$("#recentPanelTable").append(htmldiv);
				}
			});
		}
	});

}