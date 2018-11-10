
function makeArtistMain(jsonArray){
	const main = document.createElement('main');
	jsonArray.forEach(elem => {
		const div = document.createElement('div');
		div.innerHTML = `
			<h2 id="${elem.name}" data-artistId="${elem.id}">
				${elem.name}
			</h2>
		`
		div.addEventListener('click', () => {console.log('click');makeAlbumMain(elem.albums)})
		main.appendChild(div)
	})
	document.body.appendChild(main)
}

function makeAlbumMain(jsonArray){
	const main = document.createElement('main');
	jsonArray.forEach(elem => {
		const div = document.createElement('div');
		div.innerHTML += `
			<h2 id="${elem.name}" data-albumId="${elem.id}">
				${elem.name}
			</h2>
		`
		div.addEventListener('click', () => {makeSongMain(elem.songs)})
		main.appendChild(div)
	})
	document.querySelector('main').remove();
	document.body.appendChild(main)
}

function makeSongMain(jsonArray){
	console.log(jsonArray)
	const main = document.createElement('main');
	jsonArray.forEach(elem => {
		const div = document.createElement('div');
		div.innerHTML += `
			<h2 id="${elem.name}" data-songId="${elem.id}">
				${elem.name}
			</h2>
		`
		main.appendChild(div)
	})
	document.querySelector('main').remove();
	document.body.append(main)
}

module.exports = {
	makeArtistMain,
	makeAlbumMain,
	makeSongMain
}