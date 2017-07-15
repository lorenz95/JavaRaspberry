var MAX_DATA = 50;

$(document).ready(function(){
// JSON
	$("#datiPres").click(function(){
		$.get('presence.json', function(dataString) {
		      	datiTabella("presTable", dataString, "PRESENZA");
		});
	});

	$("#datiTemp").click(function(){
		$.get('temp.json', function(dataString) {
		      	datiTabella("tempTable", dataString, "TEMPERATURA");
		  });
	});
});

	function datiTabella(id, dataString, header) {
	 	var data = dataString.split("][");
		var maxElem = data.length;
		var numElem = (maxElem < MAX_DATA) ? maxElem : MAX_DATA;
		
		var elem = document.getElementById(id);	
		elem.innerHTML = "<tr> <th> DATI " + header +" </th> </tr>";
	
		for (var i = 1; i <= numElem; i++) {
			var str = data[maxElem-i];
			var k = str.indexOf(" ");
			var res = str.substring(k+1,str.length-1);
			elem.innerHTML += "<tr> <td> " + res + "</td> </tr>";
		}
	}
