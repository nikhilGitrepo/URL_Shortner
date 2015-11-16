var pageMap= {
	     URL_MAPS : 'UrlProcess/js/urlmaps/urlmaps.jsp',
	     HOME : 'HOME',
	     BACK_HOME : 'backHome',
	     URL_SUCCESS : 'UrlProcess/js/submissionResult/submissionResultSuccess.jsp',
	     URL_FAILURE : 'UrlProcess/js/submissionResult/submissionResultFailed.jsp'
	    	 };

function parallax(jumboHeight){
    var scrolled = $(window).scrollTop();
    $('.bg').css('height', (jumboHeight-scrolled) + 'px');
}

$(document).ready(function() {    	
    $(".nav-urlator").click(function(e){
    e.preventDefault();
    	if(this.id == pageMap.HOME || this.id == pageMap.BACK_HOME ){
    		$('#mainPanel').load(location.href);
    		loadRecentUrl();
    	}else if(this.id == 'URL_MAPS' ){
    			$("#mainPanel").load(pageMap[this.id]);
    			loadUrlMaps();
    	}    	
    });
    
    var jumboHeight = $('.jumbotron').outerHeight();


    $(window).scroll(function(e){
        parallax(jumboHeight);
    });
    
    //Submits url and displays the panel based on success or fail
/*    $(".urlBtn").click(function(e) {
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
    	
    	//now parse returned JSON...
    	var jsonSuccess =  '{"submitResult": {"creationResult": true, "createdId": "ourSite.com?id=myDesiredID", "longUrl": "http://longURL.com/longasldfadfagoijwigjalsdkgjalsdg"}}'
    	var jsonFailed = '{"submitResult": {"creationResult": false,"errors": ["desired Id is already taken","Could Not Access the db","etc..."]}}'
    	
    	jsonObj = JSON.parse(jsonFailed);	
    	
    	if(jsonObj.submitResult.creationResult){
    		parseSuccessfulCreation(jsonObj);
    	}else{
    		parseFailedCreation(jsonObj);
    	}   	
    	
    });*/
    
    
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
//TODO CLEAN UP THIS PAGE
function parseSuccessfulCreation(jsonObj) {	
	$('#mainPanel').load(pageMap.URL_SUCCESS, function(data){		
		$('#urlSuccess').append("<a href="+jsonObj.submitResult.createdId+">"+jsonObj.submitResult.createdId+"</a>");
		$('#urlSuccess').append("<p></p>");
		$('#urlSuccess').append("<p>Created FROM</p>");
		$('#urlSuccess').append("<p></p>");
		$('#urlSuccess').append("<a href="+jsonObj.submitResult.longUrl+">"+jsonObj.submitResult.longUrl+"</a>");
});
}
//TODO: CLEAN UP THIS PAGE
function parseFailedCreation(jsonObj){
	$('#mainPanel').load(pageMap.URL_FAILURE, function(data){		
		$('#urlFailed').append("We're sorry, your URL creation failed with the following errors:")
		$('#urlFailed').append("<p></p>");
		for(x in jsonObj.submitResult.errors)
		{
			$('#urlFailed').append("<p>"+jsonObj.submitResult.errors[x]+"</p>");
		}
	});
	
}

function loadUrlMaps(){
	$.ajax({
		type : 'GET',
		dataType : 'JSON',
		url : 'loadAll.ajax',
		success : function(data) {
			$.each(data, function(i, item) {
				if (i == '@items') {
					var htmldiv = "";
					var htmldiv = "";
					$.each(item, function(j, link) {
						htmldiv += "<tr><td><a href='" + link.shortUrl + "'>" + link.shortUrl + "</a></td><td>&nbsp;"+link.desiredId+"&nbsp;</td></tr>";
				});
				$("#urlMap").append(htmldiv);
		}
	});
	}
	});
}