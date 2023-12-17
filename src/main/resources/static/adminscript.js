
var stompClient = null;

$(document).ready(function(){
	
	if(stompClient!=null)
		stompClient.disconnect();

	 var socket = new SockJS('/livescore-websocket-match');
	 stompClient = Stomp.over(socket);
	
    $("button").click(function(){
        
    	sendData2Socket();
    	
    });
});

function sendData2Socket() {
	
	var redScore = $("#redScore").val();
	var blueScore = $("#blueScore").val();
	
	stompClient.send("/app/scoreMatch", {}, JSON.stringify({'id': 0, 'ArbitreName': 'Arbitre1', 
		'redScore': redScore,'blueScore': blueScore}));

}