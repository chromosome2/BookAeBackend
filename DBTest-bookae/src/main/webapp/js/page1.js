$(function(){

    /*조명 깜박깜박*/
    setTimeout(function(){
        $('.back-box > img').css('display','none');
    },1000);
    setTimeout(function(){
        $('.back-box > img').css('display','inline-block');
    },1300);
    setTimeout(function(){
        $('.back-box > img').css('display','none');
    },1500);
    setTimeout(function(){
        $('.back-box > img').css('display','inline-block');
    },1900);

    /*발자국*/
    setTimeout(function(){
        var count=1;
        var foot;
        foot=setInterval(function(){
            if(count<8){
                $('.back-box > p').eq(count-1).css('display','block');
            }else{
                clearInterval(foot);
            }
            count++;
            },600);
    },2200);

    /*카툰*/
    setTimeout(function(){
        $('.cartoonBox').animate({
            opacity:1
        },1500);
    },5500);
    $('#no').click(function(){
        $('.cartoonBox').fadeOut(500);
        $('.information').fadeIn(500);
    });

    var index=0;
    $('#next').click(function(){
        $('#prev').css('cursor','pointer');
        $('#prev').attr('src','images/whasal1.png');
        if(index<9){
            index++;
            $('.cartoon > img').eq(0).attr('src','images/00'+index+'.jpg');
        }else if(index>=9 && index<32) {
            index++;
            $('.cartoon > img').eq(0).attr('src','images/0'+index+'.jpg');
        }else if(index==32){
            index++;
            $('.cartoon > img').eq(0).attr('src','images/0'+index+'.jpg');
            $(this).css('cursor','default');
            $(this).attr('src','images/whasalR2.png');
        }else{
            $(this).css('cursor','default');
            $(this).attr('src','images/whasalR2.png');
        }
    });
    $('#prev').click(function(){
        $('#next').css('cursor','pointer');
        $('#next').attr('src','images/whasal2.png');
        if(index<=0){
            $(this).css('cursor','default');
            $(this).attr('src','images/whasalL2.png');
        }else if(index==1){
            index--;
            $('.cartoon > img').eq(0).attr('src','images/00'+index+'.jpg');
            $(this).css('cursor','default');
            $(this).attr('src','images/whasalL2.png');
        }else if(index<11){
            index--;
            $('.cartoon > img').eq(0).attr('src','images/00'+index+'.jpg');
        }else{
            index--;
            $('.cartoon > img').eq(0).attr('src','images/0'+index+'.jpg');
        }
    });

    /*책 설명*/
    var sw=[false,false];
    var bookcost=['일반','중고'];
    $('.cost1>p').click(function(){
        index=0;
        sw[index]=!sw[index];
        if(sw[index]){
            $(this).next().slideDown(200);
            $(this).text('※'+bookcost[index]+' 도서 가격 비교 닫기');
        }else{
            $(this).next().slideUp(200);
            $(this).text('※'+bookcost[index]+' 도서 가격 비교 보기');
        }
    });
    $('.cost2>p').click(function(){
        index=1;
        sw[index]=!sw[index];
        if(sw[index]){
            $(this).next().slideDown(200);
            $(this).text('※'+bookcost[index]+' 도서 가격 비교 닫기');
        }else{
            $(this).next().slideUp(200);
            $(this).text('※'+bookcost[index]+' 도서 가격 비교 보기');
        }
    });
});
