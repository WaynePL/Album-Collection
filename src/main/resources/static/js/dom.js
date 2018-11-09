
function makeMain(jsonArray){
	const main = document.createElement('main');
	jsonArray.forEach(elem => {

		main.innerHTML = `
			<h1>${elem.name}</h1>
		`
	})
	document.body.innerHTML += main.innerHTML
}

module.exports = {
	makeMain
}