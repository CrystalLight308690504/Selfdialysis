
/*改变图片*/
function changBannerImages(changed, imageIndex) {
    changed.style.backgroundImage = "url('images/mainPicture/banner" + imageIndex + ".jpg')";
}

function toChangeBannerImages() {
    var imageIndex = 0;
    var intervalId;
    var banner = document.getElementById('banner');

    function startChanging() {
        if (++imageIndex >= 4) {// 如果超出图片数量
            imageIndex = 0;
        }
        changBannerImages(banner, imageIndex);
        intervalId = setTimeout(startChanging, 2000);
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
