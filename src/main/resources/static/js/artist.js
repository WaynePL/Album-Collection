
function makeMain(jsonArray){
	const main = document.createElement('main');
	jsonArray.forEach(elem => {

		main.innerHTML += `
			<h2 id="${elem.name}" data-artistid="${elem.id}">
				${elem.name}
			</h2>
		`
		main.querySelector()
	})
	document.body.innerHTML += main.innerHTML
}

function getAlbums() {
	const h2s = document.querySelectorAll('.artist')

	h2s.forEach(() => {

	})
}

module.exports = {
	makeMain
}