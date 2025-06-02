document.addEventListener('DOMContentLoaded', function () {
    var carousel = document.getElementById('carousel');
    var images = carousel.getElementsByTagName('img');
    var currentImageIndex = 0;

    function switchImage() {
        // 隐藏当前图片
        images[currentImageIndex].classList.remove('visible');
        images[currentImageIndex].classList.add('hidden');

        // 计算下一张图片的索引
        currentImageIndex = (currentImageIndex + 1) % images.length;

        // 显示下一张图片
        images[currentImageIndex].classList.remove('hidden');
        images[currentImageIndex].classList.add('visible');
    }

    // 每3秒调用一次 switchImage 函数
    setInterval(switchImage, 3000);
});