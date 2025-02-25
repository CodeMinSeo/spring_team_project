$(document).ready(function(){
    <!--        비밀번호 보기/숨기기 기능구현-->
    $('.pass i').on('click',function(){
        $('input').toggleClass('active');
        if($('input').hasClass('active')){
            $(this).attr('class',"fa-regular fa-eye")
                .prev('input').attr('type',"text");
        }else{
            $(this).attr('class',"fa-regular fa-eye-slash")
                .prev('input').attr('type','password');
        }
    });
    // 로그인 버튼 클릭 시 form 실행
    $("#btn-login").on('click', function (){
        var frm = $("#frm")[0];
        frm.action = "/khamro/loginProcess"
        frm.submit();
    });
// keydown 엔터 누를 시
    $("#Pw").on('keydown',function(e){
        if(e.keyCode == 13){
            $("#btn-login").click();
        }
    })
    // 아이디 중복 확인
    $("#btn-check").on("click", function () {
        var uId = $("#user-id").val();
        if (uId == '') {
            $("#check").css("color", "red").text("ID 입력해주세요...");
            return false;
        }
        //Ajax로 실제 데이터 확인
        $.ajax({
            url: '/khamro/idCheck',
            type: "POST",
            data: {userId: uId},
            success: function (result) {
                if (result == true) {
                    $("#check").css("color", "green").text("사용 가능한 ID 입니다.");
                } else {
                    $("#check").css("color", "red").text("사용 불가능한 ID 입니다.");
                }
            },
            error: function () {
                alert("error");
            }
        });
    });
    $("#btn-register").click(function (){
        var id = $("#user-id").val();
        var Pw1 = $("#Pw1").val();
        var Pw2 = $("#Pw2").val();
        var name = $("#user-name").val();
        var birthday = $("#user-birthday").val();
        var email = $("#user-email").val();
        var phone = $("#user-phone").val();

        if (id == ""){
            alert("user-id를 입력하세요")
            $("#user-id").focus();
            return false;
        }
        if (Pw1 == ""){
            alert("Pw1를 입력하세요")
            $("#Pw1").focus();
            return false;
        }
        if (Pw2 == ""){
            alert("Pw2를 입력하세요")
            $("#Pw2").focus();
            return false;
        }
        if (name == ""){
            alert("name를 입력하세요")
            $("#user-name").focus();
            return false;
        }
        if (birthday == ""){
            alert("birthday를 입력하세요")
            $("#user-birthday").focus();
            return false;
        }
        if (email == ""){
            alert("email를 입력하세요")
            $("#user-email").focus();
            return false;
        }
        if (phone == ""){
            alert("phone를 입력하세요")
            $("#user-phone").focus();
            return false;
        }
        ("#user-id").val(userid);
        ("#Pw1").val(Pw1);
        ("#Pw2").val(Pw2);
        ("#user-name").val(name);
        ("#user-birthday").val(birthday);
        ("#user-phone").val(phone);
        ("#user-email").val(email);
    });
    
    // 패스워드 숨기기, 표시 기능 js
    $('.pw2 i').on('click', function () {
        $('input').toggleClass('active');
        if ($('input').hasClass('active')) {
            $(this).attr('class', "fa-regular fa-eye")
                .prev('input').attr('type', "text");
        } else {
            $(this).attr('class', "fa-regular fa-eye-slash")
                .prev('input').attr('type', 'password');
        }
    });

    $('.pw1 i').on('click', function () {
        $('input').toggleClass('active');
        if ($('input').hasClass('active')) {
            $(this).attr('class', "fa-regular fa-eye")
                .prev('input').attr('type', "text");
        } else {
            $(this).attr('class', "fa-regular fa-eye-slash")
                .prev('input').attr('type', 'password');
        }
    });
});
// 패스워드 체크
function pwCheck() {
    var password1 = $("#Pw1").val();
    var password2 = $("#Pw2").val();
    if (password1 == password2) {
        $('#chechingPw').text('일치하다').css('color', 'green')
    } else {
        $('#chechingPw').text('일치하지 않다').css('color', 'red')
    }
}