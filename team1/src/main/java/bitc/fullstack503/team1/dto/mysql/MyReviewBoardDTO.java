package bitc.fullstack503.team1.dto.mysql;

import lombok.Data;

import java.util.List;

@Data
public class MyReviewBoardDTO {
    private int reviewIdx;
    private String userId;
    private int UCSEQ; // 명소키
    private int UCSEQ2; // 맛집키
    private String contents;
    private int scope; // 별점
    private String createDate;
    private String updateDate;
    
    // join 해서 이미지 들고옴
    private String imageUrl;

    private List<ReviewImageDTO> ImgList;
}
