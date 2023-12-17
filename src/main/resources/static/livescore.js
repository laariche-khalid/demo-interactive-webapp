

var stompClient = null;


$(document).ready(function(){
	
	if(stompClient!=null)
		stompClient.disconnect();

	 var socket = new SockJS('/livescore-websocket-Match');
	 stompClient = Stomp.over(socket);
	 
	 stompClient.connect({}, function (frame) {
	        stompClient.subscribe('/topic/livescoreMatch', function (scoredata) {
	        	
	        	var scoreJson = JSON.parse(scoredata.body);
	        	console.log(scoreJson);
	        	// $("#batting_td").html("Batting Team: "+scoreJson.battingTeamName+" and Total runs are: "+scoreJson.totalRuns);
	        	//$("#bowling_td").html("Bowling Team: "+scoreJson.bowlingTeamName+" and Total overs are: "+scoreJson.totalOvers);
	            
	        });
	    });
	
	 
});