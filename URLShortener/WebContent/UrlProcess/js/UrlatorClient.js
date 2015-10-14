


$(document).ready(function() {

	var pageMap= {
	     URL_MAPS : 'UrlProcess/js/urlmaps/urlmaps.jsp',
	     HOME : 'Home.jsp'
	    	 };

	    	
    $(".nav-urlator").click(function(e){
    e.preventDefault();
        var contentName = this.id+'.jsp'
        $("#mainPanel").load(pageMap[this.id]);
     });
    
    

});