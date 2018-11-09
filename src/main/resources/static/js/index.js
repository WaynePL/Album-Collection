const {makeMain} = require('./dom.js')
const {fetchCall} = require('./app.js')

fetchCall('artists').then(data => {
	console.log(data)
	makeMain(data)});
// makeMain(ajaxCall('albums'));