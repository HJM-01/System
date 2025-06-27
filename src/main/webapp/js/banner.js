document.addEventListener('DOMContentLoaded', function() {
    var carousel = document.getElementById('myCarousel');
    var images = carousel.getElementsByTagName('img');
    var footer = document.getElementById('footer1');
    var currentImageIndex = 0;
    var hideTimeout;

    function switchImage() {
        // 隐藏当前图片
        images[currentImageIndex].classList.remove('visible');
        images[currentImageIndex].classList.add('hidden');

        // 计算并切换到下一张图片
        currentImageIndex = (currentImageIndex + 1) % images.length;

        // 显示下一张图片
        images[currentImageIndex].classList.remove('hidden');
        images[currentImageIndex].classList.add('visible');
    }

    // 每3秒调用一次 switchImage 函数
    var intervalId = setInterval(switchImage, 2000);

    carousel.addEventListener('mouseenter', () => {
        clearTimeout(hideTimeout); // 清除隐藏定时
        footer.classList.add('show'); // 显示底部元素
        clearInterval(intervalId);    // 停止轮播
    });

    carousel.addEventListener('mouseleave', () => {
        footer.classList.remove('show'); // 隐藏底部元素
        hideTimeout = setTimeout(() => {
            footer.classList.remove('show');
        }, 300); // 300毫秒延迟
        // 重新开始轮播
        intervalId = setInterval(switchImage, 2000);
    });

    footer.addEventListener('mouseenter', function() {
        clearTimeout(hideTimeout); // 悬停时清除隐藏定时
        footer.classList.add('show'); // 保持底部元素可见
        clearInterval(intervalId); // 停止轮播
    });

    footer.addEventListener('mouseleave', function() {
        hideTimeout = setTimeout(() => {
            footer.classList.remove('show'); // 300毫秒后隐藏底部元素
        }, 300);
        // 重新开始轮播
        intervalId = setInterval(switchImage, 2000);
    });
});














// document.addEventListener('DOMContentLoaded', function() {
//     var carousel = document.getElementById('myCarousel');
//     var images = carousel.getElementsByTagName('img');
//     var currentImageIndex = 0;
//
//     function switchImage() {
//         // 隐藏当前图片
//         images[currentImageIndex].classList.remove('visible');
//         images[currentImageIndex].classList.add('hidden');
//
//         // 计算并切换到下一张图片
//         currentImageIndex = (currentImageIndex + 1) % images.length;
//
//         // 显示下一张图片
//         images[currentImageIndex].classList.remove('hidden');
//         images[currentImageIndex].classList.add('visible');
//     }
//
//     // 每3秒调用一次 switchImage 函数
//     setInterval(switchImage, 3000);
//
//     carousel.addEventListener('mouseenter', () => {
//         footer.style.bottom = '0';
//     });
//
//     carousel.addEventListener('mouseleave', () => {
//         footer.style.bottom = '-800px';
//     });
// });
//
// var container = document.getElementById('yourContainerId');
// if(container) {
//     container.doSomething();
// }
// container.addEventListener('mouseleave', function() {
//     hideTimeout = setTimeout(function() {
//         footer.classList.remove('show');
//     }, 300); // 300毫秒延迟
// });
//
// footer.addEventListener('mouseenter', function() {
//     clearTimeout(hideTimeout);
// });
// // //
// //     // 添加鼠标进入和离开事件处理函数
// //     carousel.addEventListener('mouseenter', () => {
// //         footer.style.bottom = '0';
// //     });
// //
// //     carousel.addEventListener('mouseleave', () => {
// //         footer.style.bottom = '-800px';
// //     });
// // });
// // var hideTimeout;
//
//
//
//
