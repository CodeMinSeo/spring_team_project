package bitc.fullstack503.team1.dto.spot;

import lombok.Data;

@Data
public class SItemDTO {
    private int UC_SEQ; //순번
    private String MAIN_TITLE; // 제목 이름
    private String MAIN_IMG_THUMB; // 썸네일 이미지 사진
    private String MAIN_IMG_NORMAL; // 노말 크기 이미지 사진
    private String USAGE_DAY_WEEK_AND_TIME; //운영날짜 및 시간
    private String HLDY_INFO; //휴무일
    private String TRFC_INFO; //약도
    private String USAGE_AMOUNT; // 이용요금
    private String MIDDLE_SIZE_RM1; //편의시설
    private String CNTCT_TEL; // 연락처
    private String ADDR1; // 주소
    private String HOMEPAGE_URL; // 홈페이지 주소
    private String ITEMCNTNTS; // 상세내용
    private String GUGUN_NM; // 구군
    private String LAT; //위도
    private String LNG; //경도
}
