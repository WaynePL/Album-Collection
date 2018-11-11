parcelRequire=function(e,r,n,t){var i="function"==typeof parcelRequire&&parcelRequire,o="function"==typeof require&&require;function u(n,t){if(!r[n]){if(!e[n]){var f="function"==typeof parcelRequire&&parcelRequire;if(!t&&f)return f(n,!0);if(i)return i(n,!0);if(o&&"string"==typeof n)return o(n);var c=new Error("Cannot find module '"+n+"'");throw c.code="MODULE_NOT_FOUND",c}p.resolve=function(r){return e[n][1][r]||r},p.cache={};var l=r[n]=new u.Module(n);e[n][0].call(l.exports,p,l,l.exports,this)}return r[n].exports;function p(e){return u(p.resolve(e))}}u.isParcelRequire=!0,u.Module=function(e){this.id=e,this.bundle=u,this.exports={}},u.modules=e,u.cache=r,u.parent=i,u.register=function(r,n){e[r]=[function(e,r){r.exports=n},{}]};for(var f=0;f<n.length;f++)u(n[f]);if(n.length){var c=u(n[n.length-1]);"object"==typeof exports&&"undefined"!=typeof module?module.exports=c:"function"==typeof define&&define.amd?define(function(){return c}):t&&(this[t]=c)}return u}({"fRxd":[function(require,module,exports) {
var t=document.querySelector("main");function e(t){for(;t.hasChildNodes();)t.lastChild.remove()}function n(n){document.querySelector(".returnToArtist").style.display="none",e(t),n.forEach(function(e){var n=document.createElement("div");n.classList.add("main_content"),n.innerHTML='\n\t\t\t<img src="/images/'.concat(e.imageURL,'">\n\t\t\t<h2 id="').concat(e.name,'" data-artistId="').concat(e.id,'">\n\t\t\t\t').concat(e.name,"\n\t\t\t</h2>\n\t\t"),m(n,e.albums,i,e.name),t.appendChild(n)}),a()}function a(){var e=document.createElement("button");e.innerText="Add Artist",e.addEventListener("click",function(){var a=r("Artist Name:","artistName"),i=r("Artist Image Location:","artistUrl"),c=document.createElement("button");c.innerText="Submit",t.appendChild(c),c.addEventListener("click",function(){fetch("api/artist/add",{method:"post",body:JSON.stringify({name:a.value,imageUrl:i.value})}).then(function(t){return t.json()}).then(function(t){n(t)})}),e.remove()}),t.appendChild(e)}function i(n,a){document.querySelector(".returnToArtist").style.display="block",e(t),t.childNodes.forEach(function(t){return t.remove()}),n.forEach(function(e){var n=document.createElement("div");n.classList.add("main_content"),n.innerHTML+='\n\t\t\t<img src="/images/'.concat(e.image,'">\n\t\t\t<h2 id="').concat(e.name,'" data-albumId="').concat(e.id,'">\n\t\t\t\t').concat(e.name,"\n\t\t\t</h2>\n\t\t"),m(n,e.songs,o,e.name),t.appendChild(n)}),c()}function c(){var e=document.createElement("button");e.innerText="Add Album",e.addEventListener("click",function(){var n=r("Album Name:","albumName"),a=r("Record Label:","recordLabel"),c=r("Image Location:","albumUrl"),o=document.createElement("button");o.innerText="Submit",t.appendChild(o),o.addEventListener("click",function(){fetch("api/album/add",{method:"post",body:JSON.stringify({name:n.value,recordLabel:a.value,imageUrl:c.value,artistName:parentName})}).then(function(t){return t.json()}).then(function(t){i(t)})}),e.remove()}),t.appendChild(e)}function o(n,a){document.querySelector(".returnToArtist").style.display="block",e(t),n.forEach(function(e){var n=document.createElement("div");n.classList.add("main_content"),n.innerHTML+='\n\t\t\t<h2 id="'.concat(e.name,'" data-songId="').concat(e.id,'">\n\t\t\t\t').concat(e.name,"\n\t\t\t</h2>\n\t\t"),t.appendChild(n)}),d()}function d(){var e=document.createElement("button");e.innerText="Add Song",e.addEventListener("click",function(){var n=r("Song Name:","songName"),a=r("Run Time:","songLength"),i=document.createElement("button");i.innerText="Submit",t.appendChild(i),i.addEventListener("click",function(){fetch("api/song/add",{method:"post",body:JSON.stringify({name:n.value,length:a.value,album:parentName})}).then(function(t){return t.json()}).then(function(t){o(t)})}),e.remove()}),t.appendChild(e)}function r(t,e){var n=document.querySelector("main"),a=document.createElement("input"),i=document.createElement("label");i.innerText=t,a.id=e,a.setAttribute("type","text"),i.appendChild(a),n.appendChild(i)}function m(t,e,n,a){t.addEventListener("click",function(){n(e,a)})}module.exports={makeArtistMain:n,makeAlbumMain:i,makeSongMain:o,makeForms:r};
},{}],"A2T1":[function(require,module,exports) {
function n(n){return fetch("/api/".concat(n)).then(function(n){return n.json()})}module.exports={fetchCall:n};
},{}],"Focm":[function(require,module,exports) {
var e=require("./dom.js"),t=e.makeArtistMain,n=e.makeAlbumMain,r=e.makeSongMain,i=require("./app.js"),a=i.fetchCall;a("artists").then(function(e){console.log(e),t(e)});var o=document.querySelector(".returnToArtist");o.addEventListener("click",function(){a("artists").then(function(e){t(e)})});
},{"./dom.js":"fRxd","./app.js":"A2T1"}]},{},["Focm"], null)
//# sourceMappingURL=/index.map