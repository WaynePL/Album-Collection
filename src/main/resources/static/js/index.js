const {makeArtistMain, makeAlbumMain, makeSongMain} = require('./dom.js')
const {fetchCall} = require('./app.js')

fetchCall('artists').then(data => {
	console.log(data)
	makeArtistMain(data)
});

const returnButton = document.querySelector('.returnToArtist');
returnButton.addEventListener('click', () => {
		fetchCall('artists').then(data => {
			makeArtistMain(data)
		});
})


// makeMain(ajaxCall('albums'));