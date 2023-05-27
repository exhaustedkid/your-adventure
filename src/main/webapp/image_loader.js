draw_image(image);

function draw_image(img) {
    alert(img);
    let canvas = document.getElementById("draw");
    let ctx = canvas.getContext("2d");
    ctx.canvas.width = 1000;
    ctx.canvas.height = 1000;
    let image = new Image();
    console.log(img);
    image.src = img;
    ctx.drawImage(image, 0, 0);
}
