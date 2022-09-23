/*함수 메서드*/
//푸터시작
function citeIdong() {
    var selectMenu=document.getElementById('cite');
    var value=selectMenu.options[selectMenu.selectedIndex].value;
    $('.btncite').click(function () {
        switch (value) {
            case 'kyobo' :
                $(this).attr('href','http://kyobobook.co.kr');
                break;
            case 'yes24' :
                $(this).attr('href','http://yes24.com');
                break;
            case 'aladin' :
                $(this).attr('href','http://aladin.co.kr');
                break;
            default :
                break;
        }
    });
}
//푸터종료