function loadRecentUrl() {
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url : 'getrecent.ajax',
		success : function(data) {
			$.each(data, function(i, item) {
				if (i == '@items') {
					var htmldiv = "";
					$.each(item, function(j, link) {
						htmldiv += "<ul><a href='" + link.url + "'>" + link.url + "</a></ul>";
					});
					$("#recentPanelTable").append(htmldiv);
				}
			});
		}
	});

}