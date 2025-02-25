package bitc.fullstack503.team1.dto.place;

import lombok.Data;

import java.util.List;

@Data
public class getFoodKrDTO {
    private HeaderDTO header;
    private List<PItemDTO> item;
}
