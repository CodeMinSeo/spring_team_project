package bitc.fullstack503.team1.service.kms;

import bitc.fullstack503.team1.dto.mysql.MyPlaceDTO;
import bitc.fullstack503.team1.dto.mysql.MySpotDTO;

import java.util.List;

public interface MainPageService {
    MySpotDTO selectSpotRank() throws Exception;

    List<MyPlaceDTO> selectPlaceList() throws Exception;
}
