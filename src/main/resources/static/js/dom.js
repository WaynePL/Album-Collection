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
		addMakeMain(div, makeAlbumMain, artist) 
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
	makeCommentSection(artist.comments, artist.id, 'artist');
	makeTagSection(artist.tags, artist.id, 'artist');
}

function makeCommentSection(entityComments, parentId, entity){
	console.log(entityComments);
	const commentList = document.querySelectorAll('.comment');
	commentList.forEach(element => {element.remove()})

	entityComments.forEach(comment =>{
		const comments = document.createElement('div');
		comments.classList.add('comment');
		comments.innerHTML += `
			<p>${comment.text}</p>
		`
		main.appendChild(comments);	
	})
		//makes addTag button
	const button = document.createElement('button')
	button.innerText = 'Add Comment';
	button.addEventListener('click', () =>{
		makeForms('Username:', 'username');
		makeForms('Comment:', 'commentName');
		makeForms('Rating:', 'rating')
		const submitButton = document.createElement('button');
		const username = document.querySelector('#username')
		const commentName = document.querySelector('#commentName');
		const rating = document.querySelector('#rating')
		rating.type = 'number';
		rating.setAttribute('min', '1');
		rating.setAttribute('max', '5');
		submitButton.innerText = 'Submit';
		main.appendChild(submitButton);	

		submitButton.addEventListener('click', () => {
			fetch(`api/${entity}/${parentId}/add-comment`, {
				method: 'post',
				body: JSON.stringify({
					comment: commentName.value,
					username: username.value,
					rating: rating.value
				})
			}).then(response => response.json()).then(data => {makeCommentSection(data, parentId, entity)})
			document.querySelector('.commentName').remove();
			document.querySelector('.username').remove();
			document.querySelector('.rating').remove();
			commentName.remove();
			username.remove();
			rating.remove();
			submitButton.remove();

		})
		//removes original add button when pressed
		button.remove();
	})
	main.appendChild(button);
}

function makeTagSection(entityTags, parentId, entity){

	const tagList = document.querySelectorAll('.tag');
	tagList.forEach(element => {element.remove()})

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
			fetch(`api/${entity}/${parentId}/add-tag`, {
				method: 'post',
				body: JSON.stringify({
					name: tagName.value,
				})

			}).then(response => response.json()).then(data => {makeTagSection(data, parentId, entity)})
			document.querySelector('.tagName').remove();
			tagName.remove();
			submitButton.remove();

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
	makeCommentSection(album.comments, album.id, 'album')
	makeTagSection(album.tags, album.id, 'album')
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
	label.classList.add(id);
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

module.exports = {
	makeArtistMain,
	makeAlbumMain,
	makeSongMain,
	makeForms,
}