document.addEventListener('DOMContentLoaded', function () {
    var carousel = document.getElementById('myCarousel');
    var footer = document.getElementById('footer1');
    document.addEventListener('DOMContentLoaded', function() {
        var elements = document.getElementsByTagName('img');
        if(elements.length > 0) {
            // 你的代码
        }
    });
    // var images = carousel.getElementsByTagName('img');
    // var currentImageIndex = 0;

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

    // 添加鼠标进入和离开事件处理函数
    carousel.addEventListener('mouseenter', () => {
        footer.style.bottom = '0';
    });

    carousel.addEventListener('mouseleave', () => {
        footer.style.bottom = '-800px';
    });
});
var hideTimeout;

var container = document.getElementById('yourContainerId');
if(container) {
    container.doSomething();
}
container.addEventListener('mouseleave', function() {
    hideTimeout = setTimeout(function() {
        footer.classList.remove('show');
    }, 300); // 300毫秒延迟
});

footer.addEventListener('mouseenter', function() {
    clearTimeout(hideTimeout);
});

//
// //实现底部上拉下滑效果
// $(document).ready(function() {
//     // 1. 初始化变量
//     const $footer = $('#footer1');
//     const $petImages = $('.carousel img, .agileinfo_footer_grid1 img');
//     const $closeBtn = $('.close-btn');
//     let hideTimeout;
//
//     // 2. 为所有宠物图片添加触发类
//     $petImages.addClass('pet-trigger');
//
//     // 3. 鼠标悬停图片时显示底部面板
//     $(document).on('mouseenter', '.pet-trigger', function () {
//         clearTimeout(hideTimeout);
//         $footer.addClass('show');
//     });
//
//     // 4. 鼠标离开图片时延迟隐藏
//     $(document).on('mouseleave', '.pet-trigger', function () {
//         startHideTimeout();
//     });
//
//
//     // 2. 监听鼠标进入事件
//     banner.addEventListener('mouseenter', () => {
//         footer.style.bottom = '0'; // 上滑显示 Footer
//     });
//
//     // 3. 监听鼠标离开事件
//     banner.addEventListener('mouseleave', () => {
//         footer.style.bottom = '-800px'; // 下滑隐藏 Footer
//     });
//
//     // 7. 关闭按钮功能
//     $closeBtn.on('click', function(e) {
//         e.preventDefault();
//         $footer.removeClass('show');
//
//         // 添加临时class防止立即重新触发
//         $footer.addClass('closing');
//         setTimeout(() => {
//             $footer.removeClass('closing');
//         }, 500); // 与过渡动画时间匹配
//     });
//
//     // 修改鼠标事件判断
//     $(document).on('mouseenter', '.pet-trigger:not(.closing)', function() {
//         if(!$footer.hasClass('closing')) {
//             clearTimeout(hideTimeout);
//             $footer.addClass('show');
//         }
//     });
//
//     // 8. 延迟隐藏函数
//     function startHideTimeout() {
//         hideTimeout = setTimeout(function () {
//             $footer.removeClass('show');
//         }, 300); // 300毫秒延迟
//     }
// })
