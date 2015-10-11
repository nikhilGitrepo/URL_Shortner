


$(document).ready(function() {

	var pageMap= {
	     URL_MAPS : 'urlator/js/urlmaps/urlmaps.jsp',
	     HOME : 'home.jsp'
	    	 };

	    	
    $(".nav-urlator").click(function(e){
    e.preventDefault();
        var contentName = this.id+'.jsp'
        $("#mainPanel").load(pageMap[this.id]);
     });
    
    

});