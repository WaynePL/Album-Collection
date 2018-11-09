const {makeMain} = require('./dom.js')
const {ajaxCall} = require('./app.js')

ajaxCall('artists');
ajaxCall('albums')