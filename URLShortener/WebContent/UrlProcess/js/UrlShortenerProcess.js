function loadRecentUrl() {
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url : 'getrecent.urlview',
		success : function(data) {
			$.each(data, function(i, item) {
				if (i == '@items') {
					var count = 1;
					var htmldiv = "<table class=\"table  table-striped table-hover style=\"overflow:hidden\"><tbody>";
					$.each(item, function(i, link) {
						htmldiv += "<tr><td>"+count+"<td><a href='" + link + "'>" + link + "</a></td></tr>";
						count+=1;
					});
					htmldiv+= "</tbody></table>"
					$("#recentPanelTable").append(htmldiv);
				}
			});
		}
	});

}