//导航栏收缩功能
$(":not(#navbar_collapse)").click(function () {
    $(".collapse").collapse("hide");
})
if ($(window).width() >= 768 && $(window).width() < 1000) {
    $("#searchArea").css("width", "90px");
} else if ($(window).width() > 1000) {
    $("#searchArea").css("width", "100%");
}
else if ($(window).width() < 768) {
    $("#searchArea").css("width", "100%");
}

$(window).resize(function () {
    if ($(window).width() >= 768 && $(window).width() < 1000) {
        $("#searchArea").css("width", "90px");
    } else if ($(window).width() > 1000) {
        $("#searchArea").css("width", "100%");
    }
    else if ($(window).width() < 768) {
        $("#searchArea").css("width", "100%");
    }
})
//-----