package bitc.fullstack503.team1.mapper.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainPageMapper {
    MySpotDTO selectSpotRank() throws Exception;

    List<MyPlaceDTO> selectPlaceList() throws Exception;
}
