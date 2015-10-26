
$(document).ready(function() {

	var pageMap= {
	     URL_MAPS : 'UrlProcess/js/urlmaps/urlmaps.jsp',
	     HOME : 'HOME',
	     BACK_HOME : 'backHome',
	     URL_SUCCESS : 'UrlProcess/js/submissionResult/submissionResultSuccess.jsp',
	     URL_FAILURE : 'UrlProcess/js/submissionResult/submissionResultFailed.jsp'
	    	 };

	    	
    $(".nav-urlator").click(function(e){
    e.preventDefault();
    	if(this.id == pageMap.HOME || this.id == pageMap.BACK_HOME ){
    		$('#mainPanel').load(location.href+'#mainPanel');
    		loadRecentUrl();
    	}else{
    		$("#mainPanel").load(pageMap[this.id]);
    	}
     });
    
    //Submits url and displays the panel based on success or fail
    $(".urlBtn").click(function(e) {
    	var lUrl="";
    	var desiredId="";
    	
    	e.preventDefault();
    	switch(this.id) {
        case "navSubmit":
            lUrl=$('#lurlInput').val();
            desiredId=$('#idInput').val();
            //validate that longurl and shorturl fields are populated, if not show the warning as a modal, since thi
            // is submitted from the navbar.
            if(lUrl == "" || desiredId == ""){
            	var errorMessages = '<div class="alert alert-danger">Missing information: '
        			if(lUrl==""){
        				errorMessages+='Long URL';     					
        			}
        			if(desiredId ==""){
        				errorMessages+=' Desired Id';
        			}  
        			errorMessages += '</div>';
        		$('#navErrorMessages').html(errorMessages);
        		$('#shortenModal').modal('show');
        		return;
        	}
            
            break;
        case "panelSubmit":
        	lUrl=$('#lurlInput2').val();
            desiredId=$('#idInput2').val();
            //validate that longurl and shorturl fields are populated, if not show the warning in the panel
        	if(lUrl == "" || desiredId == ""){
        		var errorMessages = '<div class="alert alert-danger">Missing information: '
        			if(lUrl==""){
        				errorMessages+='Long URL';     					
        			}
        			if(desiredId ==""){
        				errorMessages+=' Desired Id';
        			}        		
        		errorMessages += '</div>';
        		$('#errorMessages').html(errorMessages);
        		return;
        	}else{
        		$('#errorMessages').html("");
        	}
            break;
        default:
            break;
    } 
    	console.log("longurl:"+lUrl);
    	console.log("id:"+ desiredId);
    	
    	
    	//Need to query backend for success or failure
    	if(true){
    		$('#mainPanel').load(pageMap.URL_SUCCESS);
    	}else{
    		$('#mainPanel').load(pageMap.URL_FAILURE);
    	}   	
    	
    });
    
    
    //Limit id inputs to alphanumeric and _ only
    $(".idInput").keypress(function (e) {
        var regex = new RegExp("^[a-zA-Z0-9\b_]+$");
        var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
        if (regex.test(str)) {
            return true;
        }

        e.preventDefault();
        return false;
    });
    
   // [a-zA-Z0-9!@#$%^*_|]{6,25}
   //limit Long url to html characters only 
    $("lurlInput").keypress(function(e) {
    	var regex = new RegExp("^[a-zA-Z0-9!@#$%^*_|]{6,25}+$");
    	var str = String.fromCharCode(!e.charCode ? e.which : e.charCode);
    	if(regex.test(str)){
    		return true;
    	}
    	e.preventDefault();
    	return false;
    	
    	
    });
    
    

});