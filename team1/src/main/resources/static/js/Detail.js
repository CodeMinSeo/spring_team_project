function updateBookmark(flag){
    var userId = $("#userId").val();
    var ucSeq = $("#ucSeq").val();
    var category = $("#category").val();
    $.ajax({
        url: "/SearchDetail/bookmark",
        method: "POST",
        data: {
            userId: userId,
            bookmark: flag,
            ucSeq: ucSeq,
            category: category
        },
        success: function (data) {
            if(data === true){
                alert("즐겨찾기목록 추가");
            }else if(data === false){
                alert("즐겨찾기목록 삭제");
            }
        },
        error: function (data) {
            alert("즐겨찾기 중 오류 발생" + data);
        }
    });
}

$(document).ready(function () {
    $("#btn-fv").on("click", function () {
        var crt = $(".star-icon").attr("class");

        if(crt === "star-icon empty-star"){
            $(".star-icon").removeClass("empty-star").addClass("filled-heart");
            updateBookmark(true);
        }else if (crt === "star-icon filled-heart"){
            $(".star-icon").removeClass("filled-heart").addClass("empty-star");
            updateBookmark(false);
        }
    });
    $("#reviewFrm").on("submit", function (e) {
        if($("#contents").val() === ""){
            alert("리뷰내용을 입력해주세요.");
            $("#contents").focus();
            e.preventDefault();
        }
    });

    var LAT = $("#LAT").val();
    var LNG = $("#LNG").val();
    var mapContainer = document.getElementById('map'), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(LAT, LNG), // 지도의 중심좌표
            level: 4 // 지도의 확대 레벨
        };

    // 지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    var markerPosition  = new kakao.maps.LatLng(LAT, LNG);

    // 마커를 생성합니다
    var marker = new kakao.maps.Marker({
        position: markerPosition
    });
    marker.setMap(map);
});
