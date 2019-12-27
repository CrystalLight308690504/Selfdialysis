/*改变图片*/
function changBannerImages(changed, imageIndex) {
    changed.style.backgroundImage = "url('images/mainPicture/banner" + imageIndex + ".jpg')";
}

function toChangeBannerImages() {
    var imageIndex = 0;
    var intervalId;
    var banner = document.getElementById('banner');

    function startChanging() {
        intervalId = setTimeout(startChanging, 3000);
        if (++imageIndex >= 4) {// 如果超出图片数量
            imageIndex = 0;
        }
        changBannerImages(banner, imageIndex);
    }

    function stopChanging() {
        clearInterval(intervalId);
    }

    function last(){
        if (--imageIndex <0) {
            imageIndex = 3;
        }
        changBannerImages(banner, imageIndex)
    }

    function next(){
        if (++imageIndex >=4) {
            imageIndex = 0;
        }
        changBannerImages(banner, imageIndex)
    }
    startChanging();// 开启轮播
    $('#banner_image_last').hover(stopChanging, startChanging);
    $('#banner_image_next').hover(stopChanging, startChanging);
    $('#banner_image_last').click(last);
    $('#banner_image_next').click(next);
}

changeFontColor();
toChangeBannerImages();

/*改变自我介绍的边框*/
function changeBorderColor() {

    var i = 0;
    var colors = ["#37CFF5", "#2931ff ", "#00ff18"];
    var changed = document.getElementById('introduce_self');
    function change() {
        if (i >= colors.length) {
            i = 0;
        }
        changed.style.borderColor = colors[i++];
    }

    setInterval(change, 500);
}
changeBorderColor();

/*文字淡入淡出*/

function changFade() {
    var index = 0;
    var text = {
        0:"<h2>这就是我</h2> " +
            "<p>对自己喜爱的事情,不管遇到什么困难也会去做! 喜爱去看课外的书籍增强自己的知识面 </p>"+
			"<p>个人QQ308690504</p>",
        1:"<h2>爱好</h2> " +
            "<p>轮滑 吉他</p>"+
            "<p>轮滑是我从小就喜欢的一想运动,体验穿上轮滑鞋带自己起飞的感觉!</p>"+
            "<p>一个人在寂静的地方,听着自己谈的曲子,不管自己当时的心情有多糟糕都能够慢慢平静下来!</p>"+
			"<p>个人QQ308690504</p>",
    };

    function fadeOut(){
        $('#information').fadeOut(4000,fadeIn);
    }
    function fadeIn(){
        if(++index > 1){
            index = 0;
        }
       /* alert(index);*/
        $('#information').html(text[index]);
        $('#information').fadeIn(4000,fadeOut);
    }
    fadeIn();
}
changFade() ;