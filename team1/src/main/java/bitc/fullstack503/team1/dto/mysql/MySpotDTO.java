package bitc.fullstack503.team1.dto.mysql;

import lombok.Data;

@Data
public class MySpotDTO {
    private int UCSEQ; //순번
    private String MAINTITLE; // 제목 이름
    private String MAINIMGTHUMB; // 썸네일 이미지 사진
    private String MAINIMGNORMAL; // 이미지 노말 크기 사진
    private String USAGEDAYWEEKANDTIME; //운영날짜 및 시간
    private String HLDYINFO; //휴무일
    private String TRFCINFO; //약도
    private String USAGEAMOUNT; // 이용요금
    private String MIDDLESIZERM1; //편의시설
    private String CNTCTTEL; // 연락처
    private String ADDR1; // 주소
    private String HOMEPAGEURL; // 홈페이지 주소
    private String ITEMCNTNTS; // 상세내용
    private String GUGUNNM; // 구군
    private int SCOPEAVG; // 평균 별점
    private String LAT; //위도
    private String LNG; //경도
}
