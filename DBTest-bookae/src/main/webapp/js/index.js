$(function () {
    //이미지배너 시작
    $('.imageBanner').append($('.imageBanner >img').first().clone());
    $('.imageBanner').prepend($('.imageBanner >img').eq(-2).clone());
    var index=1;
    $('.imageBanner').animate({
        left:-(index*1280)
    },'slow');
    $('#whasalR').click(function(){
        if(index<5){
            index++;
            $('.imageBanner').animate({
                left:-(index*1280)
            },'slow');
        }else{
            $('.imageBanner').css('left',0);
            index=1;
            $('.imageBanner').animate({
                left:-(index*1280)
            },'slow');
        }
    });
    $('#whasalL').click(function(){
        if(index>1){
            index--;
            $('.imageBanner').animate({
                left:-(index*1280)
            },'slow');
        }else{
            $('.imageBanner').css('left',-7680);
            index=5;
            $('.imageBanner').animate({
                left:-(index*1280)
            },'slow');
        }
    });

    $('.page1').click(function(){
        $(location).attr('href','page1.html');
    });
    //이미지배너 종료


    //베스트셀러 시작
    for(var i=0;i<3;i++){
        if(i==0){
            select(i);
        }else{
            nonselect(i);
        }
    }
    $('.bestSellerBanner section').click(function () {
        index=$(this).index();
        for(var i=0;i<3;i++){
            if(i==index){
                select(i);
            }else {
                nonselect(i);
            }
        }
    });


    $('.bestSellerBanner .box').hover(function(){
        $(this).find('.plus').stop(true,true).animate({
            top:0,
            left:0
        });
    },function(){
        $(this).find('.plus').stop(true,true).animate({
            top:-290,
            left:200
        });
    })
    //베스트셀러 종료
});


/*함수 메서드*/



//베스트셀러 시작
//선택
function select(index) {
    $('.bestSellerBanner > section:eq('+index+')').css('zIndex',10);
    $('.bestSellerBanner >section:eq('+index+') > h3 > a').css({
        fontWeight: 'bold',
        color: 'rgb(42, 148, 42)',
        background: '#fff'
    });
}
//넌셀렉
function nonselect(i) {
    $('.bestSellerBanner section:eq('+i+')').css('zIndex',0);
    $('.bestSellerBanner section:eq('+i+') > h3 > a').css({
        fontWeight: 400,
        color: 'rgb(145, 145, 145)',
        background: '#fff'
    });
}
//베스트셀러 종료
