// 在页面加载完成后，通过滚动窗口隐藏浏览器的地址栏
addEventListener("load", function () {
    setTimeout(hideURLbar, 0);
}, false);

function hideURLbar() {
    window.scrollTo(0, 1);
}