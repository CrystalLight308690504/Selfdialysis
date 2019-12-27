/*改变do_myself颜色*/
function changeFontColor() {
    var i = 0;
    var colors = ["#ffffff", "F2AF00"];
    var changedFont = document.getElementById('welcome');

    function change() {
        if (i >= colors.length) {
            i = 0;
        }
        changedFont.style.color = colors[i++];
    }

    setInterval(change, 500);
}
