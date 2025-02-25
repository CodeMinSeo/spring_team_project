package bitc.fullstack503.team1.dto.mysql;

import lombok.Data;

@Data
public class ReviewImageDTO {
    private int reviewImageIdx;
    private String imageUrl;
    //리뷰보드에서 들고오는 Idx
    private int reviewIdx; // (FK)
    private String originalFileName; // 원본이미지 이름
    private String storedFileName; // 외부이미지 위치 경로
    private long fileSize; // 파일 크기
    private String userId; // 리뷰 작성자
}
