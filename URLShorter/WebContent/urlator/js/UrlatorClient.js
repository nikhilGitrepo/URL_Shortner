$(document).ready(function() {
    $(".nav-urlator").click(function(e){
    e.preventDefault();
        var contentName = this.id+'.jsp'
        $("#mainPanel").load(contentName);
     });

});