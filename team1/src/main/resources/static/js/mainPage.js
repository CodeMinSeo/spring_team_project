$(document).ready(function () {
// 스크롤 내리면 헤더안보이게 하는 js
    var didScroll;
    var lastScrollTop = 0;
    var delta = 5; // 동작의 구현이 시작되는 위치
    var navbarHeight = $('.header-inner').outerHeight(); // 영향을 받을 요소를 선택

    $(window).scroll(function(event){
        didScroll = true;
    });

    setInterval(function() {
        if (didScroll) {
            hasScrolled();
            didScroll = false;
        }
    }, 250);

    function hasScrolled() {
        // 접근하기 쉽게 현재 스크롤의 위치를 저장한다.
        var st = $(this).scrollTop();

        // 설정한 delta 값보다 더 스크롤되었는지를 확인한다.
        if(Math.abs(lastScrollTop - st) <= delta){
            return;
        }

        // 헤더의 높이보다 더 스크롤되었는지 확인하고 스크롤의 방향이 위인지 아래인지를 확인한다.
        if (st > lastScrollTop && st > navbarHeight){
            // 스크롤 내릴때
            $('.header-inner').addClass('d-none');
        } else {
            // 스크롤 올릴때
            if(st + $(window).height() < $(document).height()) {
                $('.header-inner').removeClass('d-none');
            }
        }
        // lastScrollTop 에 현재 스크롤위치를 지정한다.
        lastScrollTop = st;
    }

    // 메인배너 명소, 맛집 카테고리 js
    // const categories = document.querySelector(".categories");
    // categories.addEventListener("click", (event) => {
    //     const filter = event.target.dataset.category;
    //     if (filter == null) {
    //         return;
    //     }
    //     const active = document.querySelector(".category--selected");
    //     active.classList.remove("category--selected");
    //     event.target.classList.add("category--selected");
    // });

    $(".categories").on("click", "[data-category]", function(event) {
        const filter = $(this).data("category");
        if (filter == null) {
            return;
        }
        $(".category--selected").removeClass("category--selected");
        $(this).addClass("category--selected");
    });

    // 메뉴 클릭시 컬러변경
    $(".dropdown-item").click(function () {
        $(".dropdown-item").removeClass("menu-active"); // 모든 메뉴의 색상 초기화
        $(this).addClass("menu-active"); // 클릭한 메뉴만 색상 변경
    });
});
// hotplace 에 슬라이드 적용 js
let index = 0;
let lastDirection = 1; // 최근 이동 방향 저장
function moveSlide(step) {
    const slider = document.querySelector(".slider");
    const totalCards = document.querySelectorAll(".card").length;
    const cardWidth = document.querySelector(".card").offsetWidth + 20;
    const maxIndex = totalCards - 1;

    if (step === -1 && lastDirection === 1) {
        index -= 1;
        if (index < 0) index = maxIndex;
    } else {
        index += step;
        if (index > maxIndex) index = 0;
        if (index < 0) index = maxIndex;
    }

    lastDirection = step;
    slider.style.transform = `translateX(${-index * cardWidth}px)`;
}
// header 메뉴 슬라이드 설정
var giMenuDuration = 700;

// 전체 메뉴를 오른쪽으로 슬라이드하여서 보여준다.
function ShowMenu() {
    $(".menu_bg").css({ display: "block" });
    $(".menu").css({ right: "-100%" });
    $(".menu").animate({ right: "0px" }, { duration: giMenuDuration });
}

// 전체 메뉴를 왼쪽으로 슬라이드하여서 닫는다.
function HideMenu() {
    $(".menu").animate(
        { right: "-100%" },
        {
            duration: giMenuDuration,
            complete: function () {
                $(".menu_bg").css({ display: "none" });
            },
        }
    );
}
