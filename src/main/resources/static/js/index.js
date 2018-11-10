const {makeArtistMain, makeAlbumMain, makeSongMain} = require('./dom.js')
const {fetchCall} = require('./app.js')

fetchCall('artists').then(data => {
	console.log(data)
	makeArtistMain(data)});
// makeMain(ajaxCall('albums'));