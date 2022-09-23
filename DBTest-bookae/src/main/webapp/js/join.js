$(function () {
    //logInfo 시작
    var cont=['5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.',
            '8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.',
            '비밀번호가 일치하지 않습니다.',
            '이미 사용중인 닉네임입니다.',
            '특수기호(-)없이 숫자만 입력해주세요.'];
    //logInfo 종료

    //이메일주소 시작
    $('#emailAfter').change(function () {
        $('#emailAfter option:selected').each(function () {
            if($(this).val()=='1'){
                $('#emailAdd').attr('disabled',false);
                $('#emailAdd').val('');
            }else{
                $('#emailAdd').val($(this).text());
                $('#emailAdd').attr('disabled',true);
            }
        });
    });
    //이메일주소 종료
});

//비밀번호 맞는지 확인
function passCheck(){
    var pass=document.getElementById('password').value;
    var passC=document.getElementById('passwordCheck').value;
    if(pass==passC){
        $('.passCInfo').text('*일치합니다');
    }else{
        $('.passCInfo').text('*비밀번호가 일치하지 않습니다.');
    }
};