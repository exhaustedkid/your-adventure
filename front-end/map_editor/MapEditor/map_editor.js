let canvas = document.getElementById("draw");
let ctx = canvas.getContext("2d");
let color = "#000";
let terrainType = "dirt"; // terrainTypeName = fileName for texture
let brushSizeValue = 5;

document.querySelector(".color-btn div").style.backgroundColor = color;

function resize() {
    ctx.canvas.width = window.innerWidth - 20;
    ctx.canvas.height = window.innerHeight;
}

resize();

function onSave() {
    const link = document.createElement('a');
    link.download = 'map.png';
    link.href = canvas.toDataURL();
    link.click();
    link.delete();
}

function onCloudSave() {

}

function toHome() {
    // this function brings user back to the registration page/catalog of maps
    window.confirm("Do you really want to exit the page without saving?")
}

function onLoad() {
    let input = document.createElement('input');
    input.type = 'file';
    input.onchange = e => {
        let file = e.target.files[0];
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = readerEvent => {
            if (canvas.getContext) {
                let map = new Image();
                map.src = file.name;
                map.onload = function () {
                    ctx.clearRect(0, 0, canvas.width, canvas.height);
                    ctx.drawImage(map, 0, 0);
                };
            }
        }
    }
    input.click();
}

function drawTerrain() {

}

function clearPage() {
    if (window.confirm("Do you really want to clear the page?")) {
        ctx.clearRect(0, 0, canvas.width, canvas.height);
    }
}

const erase = () => (ctx.globalCompositeOperation = "destination-out");

function sizeList() {
    document.querySelector(".size-list").classList.toggle("show-list");
    brushSize();
}

function brushSize() {
    let brushSet = document.getElementsByClassName("size");
    Array.prototype.forEach.call(brushSet, function (element) {
        element.addEventListener("click", function () {
            brushSizeValue = element.getAttribute("style").substr(11, 2);
        });
    });
}

let pos = {
    x: 0,
    y: 0
};

let offsetX = canvas.offsetLeft;
let offsetY = canvas.offsetTop;
function setPosition(e) {
    pos.x = parseInt(e.clientX - offsetX);
    pos.y = parseInt(e.clientY - offsetY);
}

function setActiveColor() {
    document.querySelector(".color-btn div").style.backgroundColor = color;
    ctx.strokeStyle = color;
    ctx.globalCompositeOperation = "source-over";
}

function setColor() {
    let palette = document.getElementsByClassName("color");
    Array.prototype.forEach.call(palette, function (element) {
        element.addEventListener("click", function () {
            color = element.getAttribute("style").split("--set-color:")[1];
            setActiveColor();
        });
    });
}

function colorPick() {
    color = document.getElementById("color-picker").value;
    setActiveColor();
}

function draw(e) {
    if (e.buttons !== 1) {
        return;
    }
    ctx.beginPath();
    ctx.lineWidth = brushSizeValue;
    ctx.lineCap = "round";
    ctx.strokeStyle = color;
    ctx.moveTo(pos.x, pos.y);
    setPosition(e);
    ctx.lineTo(pos.x, pos.y);
    ctx.closePath();
    ctx.stroke();
}

window.addEventListener("resize", resize);

document.addEventListener("mousemove", draw);
document.addEventListener("mousedown", setPosition);
document.addEventListener("mouseenter", setPosition);
document.getElementById("color-picker").addEventListener("change", colorPick);
setColor();
document.getElementById("size-list").addEventListener("change", brushSize);
