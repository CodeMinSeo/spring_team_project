package bitc.fullstack503.team1.dto.mysql;

import lombok.Data;

@Data
public class MyBookmarkDTO {
    private int bookmarkId;
    private String userId;
    private int spotUcseq;
    private int placeUcseq;
    private String createDate;

}
