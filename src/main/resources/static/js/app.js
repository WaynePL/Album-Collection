

function ajaxCall(address){
	const xhttp = new XMLHttpRequest()

	xhttp.onreadystatechange = function() {

		if (this.readyState == 4 && this.status == 200) {
			console.log(this.responseText)
			const allArtists = JSON.parse(this.responseText)
			makeMain(allArtists)
		}
	}

	xhttp.open('GET', `/api/${address}`, true)
	xhttp.send()
}

module.exports = {
	ajaxCall
}
