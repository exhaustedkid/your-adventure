<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="map_editor/map_editor.js" defer></script>
    <link rel="stylesheet" href="map_editor/map_editor_style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
          integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>Your Adventure</title>
</head>
<body>
<header>
    <h2> Your Adventure Map Editor </h2>
    <div class="tools">
        <button type="button" title="Save map on device" onclick="onSave()" class="btn"><i class="fa-solid fa-floppy-disk"></i></button>
        <button type="button" title="Save map on cloud" onclick="onCloudSave()" class="btn"><i class="fa-solid fa-cloud-upload"></i></button>
        <button type="button" title="Load map from device" onclick="onLoad()" class="btn"><i class="fa-solid fa-folder-open"></i></button>
        <button type="button" title="Home" onclick="toHome()" class="special_btn"><i class="fa-solid fa-home"></i></button>
        <button type="button" title="Pencil" onclick="pencil()" class="btn"><i class="fa-solid fa-pencil"></i></button>
        <button type="button" title="Add texture" onclick="addTexture()" class="btn"><i class="fa-solid fa-plus"></i></button>
        <button type="button" title="Eraser" onclick="erase()" class="btn"><i class="fa-solid fa-eraser"></i></button>
        <button type="button" title="Clear page" onclick="clearPage()" class="btn"><i class="fa-solid fa-trash"></i></button>
        <button type="button" class="color-btn btn">
            <input type="color" id="color-picker">
            <label for="color-picker">
                <div></div>
                Color
            </label>
        </button>
        <button onclick="sizeList()" class="size-btn btn"><i class="fa-solid fa-pen"></i><span>Size</span><i
                class="fa-solid fa-caret-down"></i>
            <ul class="size-list">
                <li>
                    <div class="size" style="--set-size:02px"></div>
                </li>
                <li>
                    <div class="size" style="--set-size:05px"></div>
                </li>
                <li>
                    <div class="size" style="--set-size:08px"></div>
                </li>
                <li>
                    <div class="size" style="--set-size:10px"></div>
                </li>
                <li>
                    <div class="size" style="--set-size:15px"></div>
                </li>
            </ul>
        </button>
        <div class="color-palette">
            <span class="color" style="--set-color:#000000"></span>
            <span class="color" style="--set-color:#808080"></span>
            <span class="color" style="--set-color:#800000"></span>
            <span class="color" style="--set-color:#ff0000"></span>
            <span class="color" style="--set-color:#ff4500"></span>
            <span class="color" style="--set-color:#ffff00"></span>
            <span class="color" style="--set-color:#008000"></span>
            <span class="color" style="--set-color:#00a2e8"></span>
            <span class="color" style="--set-color:#3f48cc"></span>
            <span class="color" style="--set-color:#a349a4"></span>
            <span class="color" style="--set-color:#ffffff"></span>
            <span class="color" style="--set-color:#c3c3c3"></span>
            <span class="color" style="--set-color:#b97a57"></span>
            <span class="color" style="--set-color:#ffaec9"></span>
            <span class="color" style="--set-color:#ffc90e"></span>
            <span class="color" style="--set-color:#efe4b0"></span>
            <span class="color" style="--set-color:#b5e61d"></span>
            <span class="color" style="--set-color:#99d9ea"></span>
            <span class="color" style="--set-color:#7092be"></span>
            <span class="color" style="--set-color:#c8bfe7"></span>
        </div>
    </div>
</header>
<div class="canvas-container">
    <canvas id="draw"></canvas>
</div>
</body>
</html>
