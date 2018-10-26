function httpGet(myurl) {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", myurl, false);
		xmlHttp.send(null);

		document.getElementById("Output").innerHTML = xmlHttp.response;
}

function getGetVal() {
		return document.getElementById("get").value;
}

function httpGetSingle(x) {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("GET", "http://localhost:8081/api-0.0.1-SNAPSHOT/api/movie/getMovie/" + x, false);
		xmlHttp.send(null);

		return JSON.parse(xmlHttp.response);
}

function getDeleteVal() {
		return document.getElementById("delete").value;
}

function httpDelete(x) {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("DELETE", "http://localhost:8081/api-0.0.1-SNAPSHOT/api/movie/deleteMovie/" + x, false);
		xmlHttp.send(null);

		getTable();
}

function getID() {
		return document.getElementById("id").value;
}

function getTitle() {
		return document.getElementById("title").value;
}

function getGenre() {
		return document.getElementById("genre").value;
}

function getRating() {
		return document.getElementById("rating").value;
}

function addMovie() {
		var xmlHttp = new XMLHttpRequest();
		xmlHttp.open("POST", "http://localhost:8081/api-0.0.1-SNAPSHOT/api/movie/addMovie", false);
		xmlHttp.setRequestHeader('Content-Type', 'application/json');
		xmlHttp.send(JSON.stringify({
			title: getTitle(),
			genre: getGenre(),
			ageRating: getRating()
		}));
}

function displayJSON(x) {
		var json = JSON.parse(x);

		document.getElementById("Output").innerHTML = "id: " + json.id + "<br>Title: " + json.title  + "<br>Genre: " + json.genre + "<br>Age Rating: " + json.ageRating;
}

function getTable() {
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("GET", "http://localhost:8081/api-0.0.1-SNAPSHOT/api/movie/getAllMovies", false);
	xmlHttp.send(null);
	var string = '';
	var array = eval(xmlHttp.response);
	var n = array.length;

	for (var i = 0; i < n; i++) {
		var row = array[i];
		string += "<tr><td>" + row.id + "</td><td>" + row.title + "</td><td>" + row.genre + "</td><td>" + row.ageRating + '</td><td><input type="button" value="delete" onclick=\'httpDelete('+ row.id + ')\'/>' + "</td></tr>";
	}
	
	document.getElementById("Table").innerHTML = '<th>ID</th><th>Title</th><th>Genre</th><th>Age Rating</th>' + string;
}

function updateMovie() {
	var xmlHttp = new XMLHttpRequest();
	xmlHttp.open("PUT", "http://localhost:8081/api-0.0.1-SNAPSHOT/api/movie/updateMovie/" + getID(), false);

	if (getTitle() == null) {
		var stringTitle = httpGet(getID()).title;
	} else {
		var stringTitle = getTitle();
	}

	if (getGenre() == null) {
		var stringGenre = httpGet(getID()).genre;
	} else {
		var stringGenre = getGenre();
	}

	if (getRating() == null) {
		var stringRating = httpGet(getID()).rating;
	} else {
		var stringRating = getRating();
	}


	xmlHttp.send(JSON.stringify({
		title: stringTitle,
		genre: stringGenre,
		ageRating: stringRating
	}));

	getTable();
}
