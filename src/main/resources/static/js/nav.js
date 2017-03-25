$(document).ready(function(){
    $('#hamburger').click(function(){
        $(this).toggleClass('open');
        $('.responsive-navigation').toggleClass('visible');
    });

    $('.menu').click(function(){
        $('#hamburger').toggleClass('open');
        $('.responsive-navigation').toggleClass('visible');
    });
});