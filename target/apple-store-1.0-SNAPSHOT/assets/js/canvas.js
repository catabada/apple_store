// Black
var canvasBlack = document.querySelector(".avatar.black");
var ctxBlack = canvasBlack.getContext("2d");
ctxBlack.beginPath();
ctxBlack.font = "16px Arial";
ctxBlack.fillStyle = '#fff';
ctxBlack.fillText(canvasBlack.innerHTML,6, 23);
// White
var canvasWhite = document.querySelector(".avatar.white");
var ctxWhite = canvasWhite.getContext("2d");
ctxWhite.font = "16px Arial";
ctxWhite.fillStyle = '#000';
ctxWhite.fillText(canvasWhite.innerHTML,6, 23);