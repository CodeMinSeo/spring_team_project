package bitc.fullstack503.team1.dto.place;


import lombok.Data;

@Data
public class PItemDTO {
    private int UC_SEQ;
    private int UC_SEQ2;
    private String MAIN_TITLE;
    private String MAIN_IMG_THUMB;
    private String MAIN_IMG_NORMAL;
    private String USAGE_DAY_WEEK_AND_TIME;
    private String GUGUN_NM;
    private String ADDR1;
    private String ITEMCNTNTS;
    private String RPRSNTV_MENU;
    private String CNTCT_TEL;
    private String LAT; //위도
    private String LNG; //경도
}
