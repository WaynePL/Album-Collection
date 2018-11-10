function makeForms(labelText){
	const main = document.querySelector('main');
	const input = document.createElement('input');
	const label = document.createElement('label')
	label.innerText = labelText
	input.setAttribute('type', 'text');
	label.appendChild(input)
	main.appendChild(label)
}



function makeArtistMain(jsonArray){
	const main = document.querySelector('main')
	jsonArray.forEach(elem => {
		const div = document.createElement('div');
		div.classList.add('main_content')
		div.innerHTML = `
			<h2 id="${elem.name}" data-artistId="${elem.id}">
				${elem.name}
			</h2>
		`
		addMakeMain(div, elem.albums, makeAlbumMain) 
		main.appendChild(div)
	})

	const button = document.createElement('button')
	button.innerText = 'Add Artist';
	button.addEventListener('click', () => {
		makeForms('Artist Name:');
		makeForms('Artist Image Location:')
		const submitButton = document.createElement('button')
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);
		button.remove();
	})
	main.appendChild(button)
}

function makeAlbumMain(jsonArray){
	const main = document.querySelector('main')
	console.log(main.childNodes)
	main.childNodes.forEach(elem => elem.remove())

	jsonArray.forEach(elem => {
		const div = document.createElement('div');
		div.classList.add('main_content')
		div.innerHTML += `
			<h2 id="${elem.name}" data-albumId="${elem.id}">
				${elem.name}
			</h2>
		`
		addMakeMain(div, elem.songs, makeSongMain)
		main.appendChild(div)
	})
	const button = document.createElement('button')
	button.innerText = 'Add Album';
	button.addEventListener('click', () => {
		makeForms('Album Name:');
		makeForms('Record Label:');
		makeForms('Image Location:')
		const submitButton = document.createElement('button')
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);
		button.remove();
	})
	main.appendChild(button)
}

function makeSongMain(jsonArray){
	console.log(jsonArray)
	const main = document.querySelector('main')
	main.childNodes.forEach(elem => elem.remove())

	jsonArray.forEach(elem => {
		const div = document.createElement('div');
		div.innerHTML += `
			<h2 id="${elem.name}" data-songId="${elem.id}">
				${elem.name}
			</h2>
		`
		addMakeMain(div, elem.songs)
		main.appendChild(div)
	})
	const button = document.createElement('button')
	button.innerText = 'Add Song';
	button.addEventListener('click', () => {
		makeForms('Song Name:');
		makeForms('Run Time:');
		const submitButton = document.createElement('button')
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);
		button.remove();
	})
	main.appendChild(button)
}
function addMakeMain(div, array, makeMain){
	div.addEventListener('click', () => {makeMain(array)});
}

module.exports = {
	makeArtistMain,
	makeAlbumMain,
	makeSongMain,
	makeForms
}