
function fetchCall(address){
	return fetch(`/api/${address}`).then(res => res.json())
}

// function ajaxCall(address){
// 	const xhttp = new XMLHttpRequest()

// 	return xhttp.onreadystatechange = function() {

// 		if (this.readyState == 4 && this.status == 200) {
// 			console.log(this.responseText)
// 			return JSON.parse(this.responseText)
// 		}
// 	}

// 	xhttp.open('GET', `/api/${address}`, true)
// 	xhttp.send()
// }

module.exports = {
	fetchCall
}

