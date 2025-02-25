package bitc.fullstack503.team1.mapper.init;

import bitc.fullstack503.team1.dto.place.PItemDTO;
import bitc.fullstack503.team1.dto.spot.SItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InitMapper {
    void insertSpotList(List<SItemDTO> spotList) throws Exception;

    void insertPlaceList(List<PItemDTO> placeList) throws Exception;
}
