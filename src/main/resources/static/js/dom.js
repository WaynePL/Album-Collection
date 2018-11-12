const main = document.querySelector('main')


function removeChildren(element){
	while (element.hasChildNodes()) {
		element.lastChild.remove();
	}
}

function makeArtistMain(jsonArray){
	document.querySelector('.returnToArtist').style.display = 'none';	
	removeChildren(main);
	const artistTitle = document.createElement('h2');
	artistTitle.innerText = 'Artists';
	main.appendChild(artistTitle);
	//makes artists 
	jsonArray.forEach(artist => {
		const div = document.createElement('div');
		div.classList.add('main_content')
		div.innerHTML = `
			<img src="/images/${artist.imageURL}">
			<h2 id="${artist.name}" data-artistId="${artist.id}">
				${artist.name}
			</h2>
		`
		addMakeMain(div, makeAlbumMain,artist) 
		main.appendChild(div)
	})
	makeAddArtistButton()
}

function makeAddArtistButton(){ 
	const button = document.createElement('button')
	button.innerText = 'Add Artist';
	button.addEventListener('click', () => {
		makeForms('Artist Name:', 'artistName');
		makeForms('Artist Image Location:', 'artistUrl')
		const submitButton = document.createElement('button')
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);
		
		const artistName = document.querySelector('#artistName');
		const artistUrl = document.querySelector('#artistUrl');
		submitButton.addEventListener('click', () => {
			fetch(`api/artist/add`, {
				method: 'post',
				body: JSON.stringify({
					name: artistName.value,
					imageUrl: artistUrl.value
				})
			}).then(response => response.json()).then(data => {makeArtistMain(data)})
		})
		button.remove();
	})
	main.appendChild(button)
}

function makeAlbumMain(artist){
	document.querySelector('.returnToArtist').style.display = 'block';
	removeChildren(main);
	//main.childNodes.forEach(elem => elem.remove())

	artist.albums.forEach(album => {
		const div = document.createElement('div');
		div.classList.add('main_content')
		div.innerHTML += `
			<img src="/images/${album.image}">
			<h2 id="${album.name}" data-albumId="${album.id}">
				${album.name}
			</h2>
		`
		addMakeMain(div, makeSongMain, album)
		main.appendChild(div);
	})
	makeAddAlbumButton(artist.name);
	makeTagSection(artist.tags, artist.id);
}

function makeTagSection(entityTags, parentId){
	entityTags.forEach(tag =>{
		const tags = document.createElement('div');
		tags.classList.add('tag');
		tags.innerHTML += `
			<p>${tag.tagName}</p>
		`
		main.appendChild(tags);	
	})
		//makes addTag button
	const button = document.createElement('button')
	button.innerText = 'Add Tag';
	button.addEventListener('click', () =>{
		makeForms('Tag:', 'tagName');
		const submitButton = document.createElement('button');

		const tagName = document.querySelector('#tagName');
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);	

		submitButton.addEventListener('click', () => {
			fetch(`api/${parentId}/add-tag`, {
				method: 'post',
				body: JSON.stringify({
					name: tagName.value,
				})
			}).then(response => response.json()).then(data => {makeTagSection(data)})
		})
		//removes original add button when pressed
		button.remove();
	})
	main.appendChild(button);
}

function makeAddAlbumButton(parentName) {
	//makes basic button
	const button = document.createElement('button')
	button.innerText = 'Add Album';
	//makes listener to create form with submit button
	button.addEventListener('click', () => {
		makeForms('Album Name:', 'albumName');
		makeForms('Record Label:', 'recordLabel');
		makeForms('Image Location:', 'albumUrl')
		const submitButton = document.createElement('button')
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);
		
		const albumName = document.querySelector('#albumName');
		const recordLabel = document.querySelector('#recordLabel');
		const albumUrl = document.querySelector('#albumUrl');

		//listener to submitButton then fetch new api to make page
		submitButton.addEventListener('click', () => {			
			//post new album using the appropriate input.value
			fetch(`api/album/add`, {
				method: 'post',
				body: JSON.stringify({
					name: albumName.value,
					recordLabel: recordLabel.value,
					imageUrl: albumUrl.value,
					artistName: parentName
				})
				//fetch generates new page using (V "data" right here) given back from the controller
			}).then(response => response.json()).then(data => {makeAlbumMain(data)})
		})
		//removes original add button when pressed
		button.remove();
	})
	main.appendChild(button)
}

function makeSongMain(album){
	document.querySelector('.returnToArtist').style.display = 'block';
	removeChildren(main);

	album.songs.forEach(song => {
		const div = document.createElement('div');
		div.classList.add('main_content');
		div.innerHTML += `
			<div class="song_item">
				<h2 id="${song.name}" data-songId="${song.id}">
					${song.name}
				</h2>
				<h4>${song.time}</h4>
				</div>
		`
		main.appendChild(div)
	})
	makeAddSongButton(album.name);
	makeTagSection(album.tags, album.id)
}


function makeAddSongButton(parentName){
	const button = document.createElement('button')
	button.innerText = 'Add Song';
	button.addEventListener('click', () => {
		makeForms('Song Name:', 'songName');
		makeForms('Run Time:', 'songLength');
		const submitButton = document.createElement('button')
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);
		const songName = document.querySelector('#songName')
		const songLength = document.querySelector('#songLength')

		submitButton.addEventListener('click', function(){
			fetch(`api/song/add`, {
				method: 'post',
				body: JSON.stringify({
					name: songName.value,
					length: songLength.value,
					album: parentName
				})
			}).then(response => response.json()).then(data => {makeSongMain(data)})
			
		})
		button.remove();
	})
	main.appendChild(button);
}

function makeForms(labelText, id){
	const input = document.createElement('input');
	const label = document.createElement('label')
	label.innerText = labelText;
	input.id = id;
	input.setAttribute('type', 'text');
	label.appendChild(input);
	main.appendChild(label);
}

function addMakeMain(div, makeMain, parentEntity){
	div.addEventListener('click', () => {makeMain(parentEntity)});
}

/*
function showComments(jsonArray){
	jsonArray.forEach(part => {

	})
}
*/


fetch(`api/${subject}/tag/add`, {
	method: 'post',
	body: JSONStringify({
		${subject}: tag,
		
	})
})

module.exports = {
	makeArtistMain,
	makeAlbumMain,
	makeSongMain,
	makeForms,
}