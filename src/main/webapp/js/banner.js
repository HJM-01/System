document.addEventListener('DOMContentLoaded', function () {
    var carousel = document.getElementById('myCarousel');
    var footer = document.getElementById('footer1');
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

    // 添加鼠标进入和离开事件处理函数
    carousel.addEventListener('mouseenter', () => {
        footer.style.bottom = '0';
    });

    carousel.addEventListener('mouseleave', () => {
        footer.style.bottom = '-100px';
    });
});
var hideTimeout;

container.addEventListener('mouseleave', function() {
    hideTimeout = setTimeout(function() {
        footer.classList.remove('show');
    }, 300); // 300毫秒延迟
});

footer.addEventListener('mouseenter', function() {
    clearTimeout(hideTimeout);
});



    $(document).ready(function() {
    // Cache DOM elements
    const $footer = $('#footer1');
    const $petImages = $('#myCarousel img, .agileinfo_footer_grid1 img');
    const $closeBtn = $('.close-btn');
    let hideTimeout;
    let carouselInterval;

    // Initialize functions
    function initHoverEffects() {
    // Add hover class to all pet images
    $petImages.addClass('pet-image-hover');

    // Handle image hover
    $petImages.hover(
    function() { // Mouse enter
    clearTimeout(hideTimeout);
    $footer.addClass('show');
},
    function() { // Mouse leave
    startHideTimeout();
}
    );

    // Handle footer hover
    $footer.hover(
    function() { // Mouse enter
    clearTimeout(hideTimeout);
},
    function() { // Mouse leave
    startHideTimeout();
}
    );
}

    function initCloseButton() {
    $closeBtn.on('click', function() {
    $footer.removeClass('show');
    clearTimeout(hideTimeout);
});
}

    function startHideTimeout() {
    hideTimeout = setTimeout(function() {
    $footer.removeClass('show');
}, 300); // 300ms delay before hiding
}

    function initCarousel() {
    const $carousel = $('#myCarousel');
    if (!$carousel.length) return;

    const $images = $myCarousel.find('img');
    let currentImageIndex = 0;

    // Initialize first image
    $images.eq(0).addClass('visible').removeClass('hidden');

    function switchImage() {
    $images.eq(currentImageIndex)
    .removeClass('visible')
    .addClass('hidden');

    currentImageIndex = (currentImageIndex + 1) % $images.length;

    $images.eq(currentImageIndex)
    .removeClass('hidden')
    .addClass('visible');
}

    function startCarousel() {
    stopCarousel();
    carouselInterval = setInterval(switchImage, 3000);
}

    function stopCarousel() {
    if (carouselInterval) {
    clearInterval(carouselInterval);
}
}

    // Start carousel
    startCarousel();

    // Pause on hover
    $carousel.hover(
    function() { stopCarousel(); },
    function() { startCarousel(); }
    );
}

    // Initialize all components
    function init() {
    initHoverEffects();
    initCloseButton();
    initCarousel();
}

    // Start everything
    init();
});
