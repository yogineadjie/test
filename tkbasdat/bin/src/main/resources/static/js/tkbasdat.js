$(document).ready(function () {
	//some stuff here
	$("#icon1").hover(function(){
        $("#icon_desc").text("Bad!");
        }, function(){
        $("#icon_desc").text("");
    });
	$("#icon2").hover(function(){
        $("#icon_desc").text("...");
        }, function(){
        $("#icon_desc").text("");
    });
	$("#icon3").hover(function(){
        $("#icon_desc").text("Okay");
        }, function(){
        $("#icon_desc").text("");
    });
	$("#icon4").hover(function(){
        $("#icon_desc").text("Good");
        }, function(){
        $("#icon_desc").text("");
    });
	$("#icon5").hover(function(){
        $("#icon_desc").text("Love it!");
        }, function(){
        $("#icon_desc").text("");
    });
});