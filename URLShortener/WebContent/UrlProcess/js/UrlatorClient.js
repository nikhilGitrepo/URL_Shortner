
$(document).ready(function() {

	var pageMap= {
	     URL_MAPS : 'UrlProcess/js/urlmaps/urlmaps.jsp',
	     HOME : ''
	    	 };

	    	
    $(".nav-urlator").click(function(e){
    e.preventDefault();
    	if(this.id == 'HOME'){
    		$('#mainPanel').load(location.href+'#mainPanel');
    		loadRecentUrl();
    	}else{
    		$("#mainPanel").load(pageMap[this.id]);
    	}
     });
    
    

});