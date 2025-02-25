package bitc.fullstack503.team1.dto.mysql;

import lombok.Data;

@Data
public class MyPlaceDTO {
    private int UCSEQ; //순번
    private String MAINTITLE; // 제목 이름
    private String MAINIMGTHUMB; // 썸네일 이미지 사진
    private String MAINIMGNORMAL; // 이미지 사진
    private String USAGEDAYWEEKANDTIME; // 운영날짜 및 시간 휴무일
    private String GUGUNNM; // 구군
    private String ADDR1; // 주소
    private String ITEMCNTNTS; // 상세내용
    private String RPRSNTVMENU; // 메뉴
    private String CNTCTTEL; // 연락처
    private int SCOPEAVG; // 평점
    private String LAT; //위도
    private String LNG; //경도
    private String USAGEAMOUNT;

    private String HLDYINFO;
    private String TRFCINFO;
}
