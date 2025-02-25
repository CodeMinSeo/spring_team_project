package bitc.fullstack503.team1.dto.spot;

import lombok.Data;

import java.util.List;

@Data
public class getAttractionKrDTO {
    private HeaderDTO header;
    private List<SItemDTO> item;
    private String totalCount;
}
